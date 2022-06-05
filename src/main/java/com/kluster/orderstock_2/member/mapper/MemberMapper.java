
package com.kluster.orderstock_2.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kluster.orderstock_2.member.domain.Member;

@Mapper
public interface MemberMapper {

	 List<Member> getMemberList();
}
