package org.sparta.batch.config;

import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.sparta.batch.domain.entity.product.ReservationEntity;
import org.sparta.batch.listener.JobCompletionNotificationListener;
import org.sparta.batch.repository.ReservationRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class ReservationConfig {
    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;
    private final JobRegistry jobRegistry;
    private final ReservationRepository reservationRepository;
    private final EntityManagerFactory entityManagerFactory; // EntityManagerFactory 주입

    @Bean
    public BeanPostProcessor jobRegistryBeanPostProcessor() {
        JobRegistryBeanPostProcessor postProcessor = new JobRegistryBeanPostProcessor();
        postProcessor.setJobRegistry(jobRegistry);
        return postProcessor;
    }

    @Bean
    public  JobCompletionNotificationListener jobCompletionNotificationListener() {
        return new JobCompletionNotificationListener();
    }


    @Bean
    public Job reservationJob(JobCompletionNotificationListener listener, Step reservationStep) {
        return new JobBuilder("reservationJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(reservationStep)
                .build();
    }

    @Bean
    public Step reservationStep(
            JpaPagingItemReader<ReservationEntity> reservationReader,
            ItemProcessor<ReservationEntity, ReservationEntity> reservationProcessor,
            ItemWriter<ReservationEntity> reservationWriter,
            JobCompletionNotificationListener jobCompletionNotificationListener
    ) {
        return new StepBuilder("reservationStep", jobRepository)
                .<ReservationEntity, ReservationEntity>chunk(1000, platformTransactionManager)
                .reader(reservationReader)
                .processor(reservationProcessor)
                .writer(reservationWriter)
                .listener(jobCompletionNotificationListener)
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // 기본 스레드 풀 사이즈
        executor.setMaxPoolSize(10); // 최대 스레드 수
        executor.setQueueCapacity(25); // 대기 큐 사이즈
        executor.setThreadNamePrefix("batch-");
        executor.initialize();
        return executor;
    }
}
