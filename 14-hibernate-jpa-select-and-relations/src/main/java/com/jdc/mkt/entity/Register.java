package com.jdc.mkt.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "register")
public class Register {

	@EmbeddedId
	private RegisterPk id;
	@MapsId("studentId")
	@ManyToOne
	private Student student;
	@MapsId("courseId")
	@ManyToOne
	private Course course;
	@MapsId("classRoomId")
	@ManyToOne
	private ClassRoom classroom;
}
