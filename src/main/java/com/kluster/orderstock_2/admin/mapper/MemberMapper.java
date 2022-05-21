
package com.kluster.orderstock_2.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kluster.orderstock_2.admin.domain.Member;

@Mapper
public interface MemberMapper {

	public List<Member> getMemberList();
}
