package com.kluster.orderstock_2.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kluster.orderstock_2.member.domain.Amember;
import com.kluster.orderstock_2.member.domain.MemberCategory;
import com.kluster.orderstock_2.member.mapper.AdminMemberMapper;

/*
 *   DaoImplement
 * * * * * * * * * * * * * * */

@Service
@Repository
public class AdminMemberService implements AdminMemberMapper{
    private final AdminMemberMapper adminMemberMapper;
    private static final String namespace = "com.kluster.orderstock_2.board.mapper.BoardMapper";
    private final SqlSession sqlSession;

    /*
     *  생성자 메서드
     * */
    public AdminMemberService(AdminMemberMapper adminMemberMapper, SqlSession sqlSession) {
        this.adminMemberMapper = adminMemberMapper;
        this.sqlSession = sqlSession;
    }

    public List<Amember> getMemberList(int startIndex, int pageSize){
        List<Amember> memberList = adminMemberMapper.getMemberList(startIndex,pageSize);
        return memberList;
    }

    public Amember getMemberDetail(int idx) {
        Amember memberDetail = adminMemberMapper.getMemberDetail(idx);
        return memberDetail;
    }
    public int memberModify(Amember amember) {
        int membermodify = adminMemberMapper.memberModify(amember);
        return membermodify;

    }
    public int deleteMember(int idx) {
        int deletemember = adminMemberMapper.deleteMember(idx);
        return deletemember;

    }
    public List<Amember> getMemberSearchList(Amember amember){
        return adminMemberMapper.getMemberSearchList(amember);
    }

    public List<MemberCategory> getMemberCategory(){
        List<MemberCategory> memberCategory = adminMemberMapper.getMemberCategory();
        return memberCategory;
    }
    public int getMemberListCnt() {
        return adminMemberMapper.getMemberListCnt();
    }


    /*
     * 재혁
     * * * * * * * * * * * */

    // 회원 가입 처리
    @Override
    public void register(Amember amember)throws Exception{
        sqlSession.insert(namespace + ".register", amember);
    }

    @Override
    public String getTime() {
        return sqlSession.selectOne(namespace + ".getTime");
    }

    @Override
    public void insertMember(Amember amember) {
        sqlSession.insert(namespace + ".insertMember", amember);

    }

    @Override
    public Amember readMember(String member_id) throws Exception {
        return sqlSession.selectOne(namespace + ".selectMember", member_id);
    }

    @Override
    public Amember readwithPw(String member_id, String member_password) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("memberid", member_id);
        paramMap.put("memberpassword", member_password);
        return sqlSession.selectOne(namespace+".readWithPw", paramMap);
    }

}

