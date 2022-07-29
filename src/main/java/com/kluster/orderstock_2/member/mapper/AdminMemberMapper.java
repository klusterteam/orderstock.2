package com.kluster.orderstock_2.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kluster.orderstock_2.member.domain.Amember;
import com.kluster.orderstock_2.member.domain.Member;
import com.kluster.orderstock_2.member.domain.MemberCategory;
import com.kluster.orderstock_2.util.Pagination;

@Mapper
public interface AdminMemberMapper {
	List<Amember> getMemberList(int startIndex , int pageSize);
	
	Amember getMemberDetail(int idx);
	
	int memberModify(Amember amember);
	
	int deleteMember(int idx);
	
	List<Amember> getMemberSearchList(Amember amember);
	
	List<MemberCategory> getMemberCategory();
	
	int getMemberListCnt();
}
