package com.kluster.orderstock_2.member.repository;

import com.kluster.orderstock_2.member.domain.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;


/* Impl */
@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setIdx(++sequence);
        store.put(member.getIdx(), member);
        return member;
    }

    /* 멤버 인덱스 */
    @Override
    public Optional<Member> findByIdx(Long idx) {
        return Optional.ofNullable(store.get(idx));
    }

    /* 이름 저장 */
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getMember_name().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
