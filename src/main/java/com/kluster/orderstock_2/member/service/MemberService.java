package com.kluster.orderstock_2.member.service;

import com.kluster.orderstock_2.member.domain.Member;
import com.kluster.orderstock_2.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    /* 외부에서 넣어주는것 DI */
    @Autowired
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
        memberRepository.findByName(member.getMember_name())
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
