package com.jdc.mkt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.entity.Member;

public interface MemberRepo extends JpaRepository<Member, Integer> {

}
