package com.kluster.orderstock_2.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kluster.orderstock_2.member.domain.Amember;
import com.kluster.orderstock_2.member.domain.Member;
import com.kluster.orderstock_2.member.mapper.AdminMemberMapper;

@Service
public class AdminMemberService {
    private final AdminMemberMapper adminMemberMapper;

    public AdminMemberService(AdminMemberMapper adminMemberMapper) {
        this.adminMemberMapper = adminMemberMapper;
    }
    
    public List<Amember> getMemberList(){
    	List<Amember> memberList = adminMemberMapper.getMemberList();
    	return memberList;
    }
    
    public Amember getMemberDetail(int idx) {
    	Amember memberDetail = adminMemberMapper.getMemberDetail(idx);
    	return memberDetail;
    }
    public int memberModipy(Amember amember) {
    	int membermodipy = adminMemberMapper.memberModipy(amember);
    	return membermodipy;
    	
    }
}
