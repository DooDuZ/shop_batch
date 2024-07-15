package org.sparta.batch.repository;

import java.util.List;
import org.sparta.batch.domain.entity.order.OrderDetailEntity;
import org.sparta.batch.domain.entity.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {
    List<OrderDetailEntity> findByOrderEntity(OrderEntity orderEntity);
    List<OrderDetailEntity> findAllByOrderEntityIn(List<OrderEntity> orderEntities);
}
