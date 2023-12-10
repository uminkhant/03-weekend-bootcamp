package com.jdc.mkt.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jdc.mkt.dto.Member;

@Component
public class MemberRowMapper implements RowMapper<Member>{

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		var member = new Member(rs.getString("name"),rs.getString("loginId"),rs.getString("password"));
		member.setName(rs.getString("name"));
		member.setLoginId(rs.getString("loginId"));
		member.setPassword(rs.getString("password"));
		return member;
	}

}
