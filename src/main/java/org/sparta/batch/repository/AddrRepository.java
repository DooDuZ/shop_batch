package org.sparta.batch.repository;

import java.util.List;
import org.sparta.batch.domain.entity.member.AddrEntity;
import org.sparta.batch.domain.entity.member.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddrRepository extends JpaRepository<AddrEntity, Long> {
    List<AddrEntity> findAllByMemberEntity(MemberEntity memberEntity);
}
