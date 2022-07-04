package com.kluster.orderstock_2.member.repository;

import com.kluster.orderstock_2.member.domain.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
/*DAO*/

/* 07.01 */

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByIdx(Long idx);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}


