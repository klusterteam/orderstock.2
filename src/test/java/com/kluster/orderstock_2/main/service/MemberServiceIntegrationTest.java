package com.kluster.orderstock_2.main.service;

import com.kluster.orderstock_2.main.domain.Member;
import com.kluster.orderstock_2.main.repository.MemberRepository;
import com.kluster.orderstock_2.main.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService ;
    @Autowired MemberRepository memberRepository;

   /*
   * 06.10
   * *//* 테스트 코드는 한글이름으로 가능 *//*
    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("Test code");

        // when 검증
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberRepository.findByIdx(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


        // then
        */

    @Test
    public void 회원가입() {
        // given
        Member member = new Member();
        member.setName("Test code");

        // when 검증
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberRepository.findByIdx(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


        // then
    }
}