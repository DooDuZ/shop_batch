package org.sparta.batch.domain.entity.product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sparta.batch.constant.ProductStatus;

@Entity(name = "reservation")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @Column(nullable = false)
    private LocalDateTime openDateTime;

    @Column(nullable = false)
    private ProductStatus reserveStatus;

    @Column(nullable = false)
    private boolean completed;

    @ManyToOne(cascade = CascadeType.MERGE)
    @ToString.Exclude
    @JoinColumn(name = "productId")
    private ProductEntity productEntity;
}
