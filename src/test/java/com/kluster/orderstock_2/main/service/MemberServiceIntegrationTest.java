/*
package com.kluster.orderstock_2.main.service;

import com.kluster.orderstock_2.member.domain.Member;
import com.kluster.orderstock_2.member.repository.MemberRepository;
import com.kluster.orderstock_2.member.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService ;
    @Autowired MemberRepository memberRepository;

   */
/*
   * 06.10
   * *//*
*/
/* 테스트 코드는 한글이름으로 가능 *//*
*/
/*
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
        *//*


    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setMember_name("name1122");
        member.setMember_id("id__");
        member.setMember_password("password");
        member.setMember_address("address");
        member.setMember_email("email");
        member.setMember_phone(123455);

        // when 검증
        Long saveIdx = memberService.join(member);

        // then
        Member findMember = memberRepository.findByIdx(saveIdx).get();
        System.out.println("member.getname = "+member.getMember_name());
        System.out.println("findemember.getname = "+findMember.getMember_name());
        assertEquals(member.getMember_name(),findMember.getMember_name());
        System.out.println("member.getid = " + member.getMember_id());
        System.out.println("member.password = " + member.getMember_password());
        System.out.println("member.address = " + member.getMember_address());
        System.out.println("member.email = " + member.getMember_email());
        System.out.println("member.phone = " + member.getMember_phone());
        */
/* AssertThat(Actual).isEqualTo(expected) *//*

    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setMember_name("spring");

        Member member2 = new Member();
        member2.setMember_name("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


        // then
    }

    */
/*@Test
    public void 로그인() throws Exception{
        Member member = new Member();
        // 변수 선언 및 초기화

        member.setMember_id("test1");
        member.setMember_password("test1");

        memberRepository.getMember(member)
        System.out.println("결과 값 : " + memberRepository.getMember(member));
    }*//*

}*/
