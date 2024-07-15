package org.sparta.batch.service;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sparta.batch.domain.entity.product.ReservationEntity;
import org.sparta.batch.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    /*@Transactional
    public void updateAllProductStatus(LocalDateTime dateTime){
        List<ReservationEntity> reservationEntities = reservationRepository.findAllByCompletedFalseAndOpenDateTimeLessThanEqual(dateTime);

        for(ReservationEntity reservationEntity : reservationEntities){
            reservationEntity.setCompleted(true);
            // product Service 의 책임 아닐까
            reservationEntity.getProductEntity().setProductStatus(reservationEntity.getReserveStatus());
        }
    }*/
}
