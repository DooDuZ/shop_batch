package org.sparta.batch.domain.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sparta.batch.constant.ProductStatus;
import org.sparta.batch.domain.BaseEntity;
import org.sparta.batch.domain.entity.member.MemberEntity;

@Entity(name = "product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Setter
public class ProductEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String productName;

    @Lob
    @Column(nullable = false)
    private String productDetail;

    @Column(nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "productCategoryId")
    private CategoryEntity categoryEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "memberId")
    private MemberEntity sellerEntity;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    public void init(CategoryEntity categoryEntity, MemberEntity sellerEntity) {
        setProductStatus(ProductStatus.NOT_PUBLISHED);
        setCategoryEntity(categoryEntity);
        setSellerEntity(sellerEntity);
    }
}
