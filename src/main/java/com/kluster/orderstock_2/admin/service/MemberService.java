package com.kluster.orderstock_2.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kluster.orderstock_2.admin.domain.Member;
import com.kluster.orderstock_2.admin.mapper.MemberMapper;

@Service
public class MemberService {
	private final MemberMapper memberMapper;
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	public List<Member> getMember(){
		List<Member> memberList = memberMapper.getMemberList();
		return  memberList;
	}
	
}
