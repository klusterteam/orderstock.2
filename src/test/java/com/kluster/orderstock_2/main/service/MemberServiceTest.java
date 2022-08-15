/*
package com.kluster.orderstock_2.main.service;

import com.kluster.orderstock_2.member.domain.Member;
import com.kluster.orderstock_2.member.repository.MemoryMemberRepository;
import com.kluster.orderstock_2.member.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService ;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    */
/* 테스트 코드는 한글이름으로 가능 *//*

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setMember_name("spring");

        // when 검증
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getMember_name()).isEqualTo(findMember.getMember_name());
    }

    @Test
    public void 중복_회원_예외(){
        // given
        Member member1 = new Member();
        member1.setMember_name("spring");

        Member member2 = new Member();
        member2.setMember_name("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

       */
/* try{
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다."); *//*
*/
/* 이미 존재하는 회원입니다.<< 이부분이 다르면 오류 *//*
*/
/*
        }*//*



        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}*/
