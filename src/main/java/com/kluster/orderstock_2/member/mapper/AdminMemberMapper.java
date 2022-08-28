package com.kluster.orderstock_2.member.mapper;

import java.lang.reflect.Member;
import java.util.List;

import com.kluster.orderstock_2.member.domain.MemberLogin;
import org.apache.ibatis.annotations.Mapper;

import com.kluster.orderstock_2.member.domain.Amember;
import com.kluster.orderstock_2.member.domain.MemberCategory;

import javax.servlet.http.HttpSession;

/*
 *   Dao
 * * * * * * * * * * * * * * */

@Mapper
public interface AdminMemberMapper {

	List<Amember> getMemberList(int startIndex , int pageSize);

	Amember getMemberDetail(int idx);

	int memberModify(Amember amember);

	int deleteMember(int idx);

	List<Amember> getMemberSearchList(Amember amember);

	List<MemberCategory> getMemberCategory();

	int getMemberListCnt();

	/*
	*
	* 	재혁
	*	DAO
	*
	* */

	void register(Amember amember) throws Exception;

	// 현재시간체크
	public String getTime();

	// 회원 입력
	public void insertMember(Amember amember);

	// 회원 아이디로 조회
	public Amember readMember(String member_id) throws Exception;

	// 회원아이디, 비밀번호로 조회
	public Amember readwithPw(String member_id, String member_password) throws Exception;

	// 회원 로그인 정보
	public Amember viewMember(Amember vo);

	// 회원 로그인 체크
	public boolean loginCheck(Amember vo, HttpSession httpSession);

	// 회원 로그아웃
	public void logout(HttpSession httpSession);

	//회원 정보 조회(로그인, 내정보)
	public Amember getMemberInfoById(String memberId);

	//전체 회원 로그인 내역 입력
	public int addLogin(MemberLogin memberLogin);

}
