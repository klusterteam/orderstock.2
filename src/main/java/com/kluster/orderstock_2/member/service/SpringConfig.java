package com.kluster.orderstock_2.member.service;

import com.kluster.orderstock_2.member.aop.TimeTraceAop;
import com.kluster.orderstock_2.member.repository.JdbcMemberRepository;
import com.kluster.orderstock_2.member.repository.JpaMemberRepository;
import com.kluster.orderstock_2.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    /*datasource*/
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /*private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
       /*`

       return new MemoryMemberRepository();
       return new JdbcMemberRepository(dataSource);


       */
        /*return new JpaMemberRepository(em);*/
        return new JdbcMemberRepository(dataSource);
    }
}
