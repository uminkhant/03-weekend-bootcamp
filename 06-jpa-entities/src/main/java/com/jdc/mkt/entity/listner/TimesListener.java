package com.jdc.mkt.entity.listner;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class TimesListener {

	@PrePersist
	public void beforeCreate(Object obj) {
		
		if(obj instanceof TimesOperator entity) {
			var times = entity.getTimes();
			if(null == times) {
				times = new Times();
				times.setCreateTime(LocalDateTime.now());
			}
			entity.setTimes(times);
		}
	}
	
	@PreUpdate
	public void beforeUpdate(Object obj) {
		if(obj instanceof TimesOperator entity) {
			var times = entity.getTimes();
			if(null == times) {
				times = new Times();
				times.setUpdateTime(LocalDateTime.now());
			}
			entity.setTimes(times);
		}
	}
}
