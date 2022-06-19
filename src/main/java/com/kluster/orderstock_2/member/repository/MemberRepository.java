package com.kluster.orderstock_2.member.repository;

import com.kluster.orderstock_2.member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByIdx(Long idx);
    Optional<Member> findById(String id);

/*    *//* 페이징 - 총 갯수 *//*
    List<Member> pageTotalNum();*/

    Optional<Member> findByName(String name);
    List<Member> findAll();
}
