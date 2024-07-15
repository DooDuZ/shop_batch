package org.sparta.batch.repository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.sparta.batch.constant.ProductStatus;
import org.sparta.batch.domain.entity.product.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE `product` SET `productStatus` = :productStatus WHERE `productStatus` = :prevStatus", nativeQuery = true)
    void openAllProductStatus(@Param("prevStatus") ProductStatus prevStatus, @Param("productStatus") ProductStatus productStatus);
}
