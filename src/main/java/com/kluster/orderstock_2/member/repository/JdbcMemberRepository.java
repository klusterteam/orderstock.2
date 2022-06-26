package com.kluster.orderstock_2.member.repository;


import com.kluster.orderstock_2.member.domain.Member;
import org.apache.ibatis.session.SqlSession;
import org.hibernate.service.spi.InjectService;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// DAO
public class JdbcMemberRepository implements MemberRepository{

    private DataSource dataSource;

    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member os_member){
        String sql = "insert into os_member(member_name, member_id,member_password,member_email,member_address,member_phone) values(?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, os_member.getMember_name());
            pstmt.setString(2, os_member.getMember_id());
            pstmt.setString(3, os_member.getMember_password());
            pstmt.setString(4, os_member.getMember_email());
            pstmt.setString(5, os_member.getMember_address());
            pstmt.setLong(6, os_member.getMember_phone());

            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                os_member.setIdx(rs.getLong(1));
            } else {
                throw new SQLException("id 조회 실패");
            }
            return os_member;
        }catch (Exception e){
            throw new IllegalStateException(e);
        }finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<Member> findByIdx(Long idx) {
        String sql = "select * from os_member where idx = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, idx);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                Member member = new Member();
                member.setIdx(rs.getLong("idx"));
                member.setMember_name(rs.getString("member_name"));
                return Optional.of(member);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public List<Member> findAll() {
        String sql = "select * from os_member";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<Member> members = new ArrayList<>();
            while(rs.next()) {
                Member member = new Member();
                member.setIdx(rs.getLong("idx"));
                member.setMember_name(rs.getString("member_name"));
                member.setMember_id(rs.getString("member_id"));
                member.setMember_password(rs.getString("member_password"));
                member.setMember_address(rs.getString("member_address"));
                member.setMember_email(rs.getString("member_email"));
                members.add(member);
            }
            return members;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<Member> findByName(String name) {
        String sql = "select * from os_member where member_name = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                Member member = new Member();
                member.setIdx(rs.getLong("idx"));
                member.setMember_name(rs.getString("member_name"));
                return Optional.of(member);
            }
            return Optional.empty();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }
    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }
    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
    {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }
}
