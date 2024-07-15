package org.sparta.batch.repository;

import java.util.Optional;
import org.sparta.batch.domain.entity.member.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 아이디 검색
    Optional<MemberEntity> findByLoginId(String loginId);

    // 이메일 검색
    Optional<MemberEntity> findByEmail(String email);
}
