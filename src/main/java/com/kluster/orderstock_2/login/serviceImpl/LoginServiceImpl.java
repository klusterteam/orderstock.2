package com.kluster.orderstock_2.login.serviceImpl;

import com.kluster.orderstock_2.login.domain.LoginVO;
import com.kluster.orderstock_2.login.service.LoginDAO;
import com.kluster.orderstock_2.login.service.LoginService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService {

    private LoginDAO loginDao;

    @Override
    public boolean loginCheck(LoginVO vo, HttpSession httpSession) {
        boolean result = loginDao.loginCheck(vo);
        if(result){ // true일 경우 세션에 등록
            LoginVO vo1 = viewMember(vo);
            // 세션 변수 등록
            httpSession.setAttribute("memberId", vo1.getMemberId());
            httpSession.setAttribute("memberName", vo1.getMemberName());
        }
        return result;
    }

    @Override
    public LoginVO viewMember(LoginVO vo) {
        return loginDao.viewMember(vo);
    }

    @Override
    public void logout(HttpSession httpSession) {
        // 세션 변수 개별 삭제
        // session.removeAttribute("memberId");
        // 세션 정보를 초기화 시킴
        httpSession.invalidate();
    }
}
