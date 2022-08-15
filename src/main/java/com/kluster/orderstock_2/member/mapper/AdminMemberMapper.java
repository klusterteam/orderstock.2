package com.kluster.orderstock_2.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kluster.orderstock_2.member.domain.Amember;
import com.kluster.orderstock_2.member.domain.MemberCategory;
import org.springframework.stereotype.Repository;

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

	void register(Amember amember) throws Exception;

	// 현재시간체크
	public String getTime();

	// 회원 입력
	public void insertMember(Amember amember);

	// 회원 아이디로 조회
	public Amember readMember(String member_id) throws Exception;

	// 회원아이디, 비밀번호로 조회
	public Amember readwithPw(String member_id, String member_password) throws Exception;
}
