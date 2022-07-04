package com.kluster.orderstock_2.member.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(of = "member_id")
/*DTO*/
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;
    private String member_name;
    private String member_id;
    private String member_password;
    private String member_email;
    private int member_phone;
    private String member_address;

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_password() {
        return member_password;
    }

    public void setMember_password(String member_password) {
        this.member_password = member_password;
    }

    public String getMember_email() {
        return member_email;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }

    public int getMember_phone() {
        return member_phone;
    }

    public void setMember_phone(int member_phone) {
        this.member_phone = member_phone;
    }

    public String getMember_address() {
        return member_address;
    }

    public void setMember_address(String member_address) {
        this.member_address = member_address;
    }


    @Override
    public String toString() {
        return "Member{" +
                "idx=" + idx +
                ", member_name='" + member_name + '\'' +
                ", member_id='" + member_id + '\'' +
                ", member_password='" + member_password + '\'' +
                ", member_email='" + member_email + '\'' +
                ", member_phone='" + member_phone + '\'' +
                ", member_address='" + member_address + '\'' +
                '}';
    }

    @Builder
    public Member(String member_id, String member_name, String member_password){
        this.member_id = member_id;
        this.member_name = member_name;
        this.member_password = member_password;
    }


    /* 07.01 */
/*
    @CreationTimestamp
    private Date regdate;

    @UpdateTimestamp
    private Date updatedate;

   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private List<MemberRole> roles;*/
}
