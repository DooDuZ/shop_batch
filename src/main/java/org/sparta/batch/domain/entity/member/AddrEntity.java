package org.sparta.batch.domain.entity.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.sparta.batch.domain.BaseEntity;

@Entity(name = "addr")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddrEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addrId;
    @Column(nullable = false)
    private String addr;
    @Column(nullable = false)
    private String addrDetail;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setAddrDetail(String addr_detail) {
        this.addrDetail = addr_detail;
    }
}
