package com.jdc.mkt.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

import com.jdc.mkt.dto.Student;

@Component
public class StudentDao {

	private JdbcOperations template;
		
	public StudentDao(JdbcOperations template) {
		super();
		this.template = template;
	}

	public int insertStudent(Student st) {
		var row = template.update("insert into student_tbl values(?,?,?)",
				st.getName(),st.getAge(),st.getDob());
		return row;
	}
}
