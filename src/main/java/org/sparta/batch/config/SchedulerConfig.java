package org.sparta.batch.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class SchedulerConfig {
    private final JobLauncher jobLauncher;

    @Scheduled(fixedDelay = 60000)
    public void performDailyJob() throws Exception {
        System.out.println("test");
        //jobLauncher.run(statVideoJob, new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters());
        //jobLauncher.run(statAdJob, new JobParametersBuilder().addLong("time", System.currentTimeMillis() + 1).toJobParameters());
        //jobLauncher.run(paymentVideoJob, new JobParametersBuilder().addLong("time", System.currentTimeMillis() + 2).toJobParameters());
        //jobLauncher.run(paymentAdJob, new JobParametersBuilder().addLong("time", System.currentTimeMillis() + 3).toJobParameters());
    }

    @Scheduled(fixedDelay = 600000)
    public void performProductJob() throws Exception {
        System.out.println("test2");
        //jobLauncher.run(statVideoJob, new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters());
        //jobLauncher.run(statAdJob, new JobParametersBuilder().addLong("time", System.currentTimeMillis() + 1).toJobParameters());
        //jobLauncher.run(paymentVideoJob, new JobParametersBuilder().addLong("time", System.currentTimeMillis() + 2).toJobParameters());
        //jobLauncher.run(paymentAdJob, new JobParametersBuilder().addLong("time", System.currentTimeMillis() + 3).toJobParameters());
    }
}
