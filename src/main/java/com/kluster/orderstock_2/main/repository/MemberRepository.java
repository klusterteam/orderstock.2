package com.kluster.orderstock_2.main.repository;

import com.kluster.orderstock_2.main.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByIdx(Long idx);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
