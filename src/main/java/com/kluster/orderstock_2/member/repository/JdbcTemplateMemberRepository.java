package com.kluster.orderstock_2.member.repository;

import com.kluster.orderstock_2.member.domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplateMemberRepository implements MemberRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateMemberRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("os_member").usingGeneratedKeyColumns("idx");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", member.getMember_name());
        parameters.put("id", member.getMember_id());
        parameters.put("password", member.getMember_password());
        parameters.put("address", member.getMember_address());
        parameters.put("email", member.getMember_email());
        parameters.put("phone", member.getMember_phone());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        member.setIdx(key.longValue());
        return member;
    }

    @Override
    public Optional<Member> findByIdx(Long idx) {
        List<Member> result = jdbcTemplate.query("select * from os_member where idx = ?", memberRowMapper(), idx);
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = jdbcTemplate.query("select * from os_member where member_name = ?", memberRowMapper(), name);
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from os_member", memberRowMapper());
    }

    private RowMapper<Member> memberRowMapper(){
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setIdx(rs.getLong("idx"));
            member.setMember_name(rs.getString("member_name"));
            member.setMember_email(rs.getString("getMember_email"));
            member.setMember_address(rs.getString("getMember_address"));
            member.setMember_password(rs.getString("getMember_password"));
            member.setMember_id(rs.getString("getMember_id"));
            member.setMember_phone(rs.getInt("getMember_phone"));

            return member;
        };
    }
}
