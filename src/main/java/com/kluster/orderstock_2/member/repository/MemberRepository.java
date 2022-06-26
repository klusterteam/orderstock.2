package com.kluster.orderstock_2.member.repository;

import com.kluster.orderstock_2.member.domain.Member;

import java.util.List;
import java.util.Optional;
/*DAO*/
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByIdx(Long idx);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}


