package com.kluster.orderstock_2.main.service;

import com.kluster.orderstock_2.main.domain.Member;
import com.kluster.orderstock_2.main.repository.MemberRepository;
import com.kluster.orderstock_2.main.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    /* 외부에서 넣어주는것 DI */
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /* Test 단축키 Cntl + Shift + T */
    /* 회원가입 */
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원 X
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getIdx();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /* 전체 회원 조회 */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberIdx){
        return memberRepository.findByIdx(memberIdx);
    }
}