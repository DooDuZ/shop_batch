package com.sparta.shop_sparta.domain.entity.member;

import com.sparta.shop_sparta.domain.dto.member.AddrDto;
import com.sparta.shop_sparta.domain.entity.BaseEntity;
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

    public AddrDto toDto() {
        return AddrDto.builder().addr(this.addr).addrDetail(this.addrDetail).addrId(this.addrId)
                .memberId(this.memberEntity.getMemberId()).build();
    }
}
