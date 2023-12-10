package com.jdc.mkt.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jdc.mkt.dto.Student;

@MapRow
public class StudentMapRow implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		var s = new Student();
		s.setName(rs.getString(1));
		s.setAge(rs.getInt(2));
		s.setDob(rs.getDate(3).toLocalDate());

		return s;
		
	}

	
}
