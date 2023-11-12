package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Convert;
import javax.persistence.Embeddable;

import com.jdc.mkt.convert.PhoneConverter;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;
	@NonNull
	private String email;
	@NonNull
	@Convert(converter = PhoneConverter.class)
	private Integer phone;
}
