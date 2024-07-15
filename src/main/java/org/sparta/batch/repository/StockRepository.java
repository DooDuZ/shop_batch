package org.sparta.batch.repository;

import jakarta.transaction.Transactional;
import java.util.Optional;
import org.sparta.batch.domain.entity.product.ProductEntity;
import org.sparta.batch.domain.entity.product.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {
    Optional<StockEntity> findByProductEntity(ProductEntity productEntity);
    Optional<StockEntity> findByProductEntity_ProductId(Long productId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `stock` SET amount = amount - :amount WHERE stock_id = :stockId", nativeQuery = true)
    void updateStockAfterOrder(@Param("stockId") Long stockId, @Param("amount") Long amount);
}
