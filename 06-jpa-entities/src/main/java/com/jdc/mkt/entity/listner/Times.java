package com.jdc.mkt.entity.listner;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Times implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
}
