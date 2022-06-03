package com.kluster.orderstock_2.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kluster.orderstock_2.member.domain.Member;
import com.kluster.orderstock_2.member.mapper.MemberMapper;

@Service
public class MemberService {
	private final MemberMapper memberMapper;
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	public List<Member> getMemberList(){
		List<Member> memberList = memberMapper.getMemberList();
		return  memberList;
	}
	
}
