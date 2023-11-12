package com.jdc.mkt.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class RegisterPk implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(name="student_id",nullable = false)
	private String studentId;
	@Column(name="classroom_id",nullable = false)
	private String classRoomId;
//	@ElementCollection
//	private List<String> tags;

}
