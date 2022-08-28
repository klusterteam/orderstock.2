package com.kluster.orderstock_2.login.serviceImpl;

import com.kluster.orderstock_2.login.domain.LoginVO;
import com.kluster.orderstock_2.login.service.LoginDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;

@Repository
public class LoginDAOimpl implements LoginDAO {
    // SqlSession 객체를 스프링에서 생성하여 주입
    // 의존관계 주입(Dependency Injection), 느슨한 결합

    private SqlSession sqlSession;

    @Override
    // 회원 로그인 체크
    public boolean loginCheck(LoginVO vo) {
        String name = sqlSession.selectOne("member.loginCheck", vo);
        return (name == null) ? false : true;
    }

    @Override
    // 회원 로그인 정보
    public LoginVO viewMember(LoginVO vo) {
        return sqlSession.selectOne("member.viewMember", vo);
    }

    @Override
    // 로그 아웃
    public void logout(HttpSession httpSession) {

    }
}
