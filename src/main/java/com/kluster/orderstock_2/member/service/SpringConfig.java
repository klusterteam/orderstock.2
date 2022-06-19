package com.kluster.orderstock_2.member.service;

import com.kluster.orderstock_2.member.repository.JdbcMemberRepository;
import com.kluster.orderstock_2.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;
    /*
    private final EntityManager entityManager;
    */

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
       /*
       return new JdbcMemberRepository(dataSource);
       */
       return new JdbcMemberRepository(dataSource);
    }
}
