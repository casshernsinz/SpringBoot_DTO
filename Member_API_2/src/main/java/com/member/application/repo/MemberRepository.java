package com.member.application.repo;

import javax.persistence.Cacheable;

import org.springframework.data.repository.CrudRepository;

import com.member.application.model.Member;
import com.member.application.model.VO.MemberDTO;

@Cacheable
public interface MemberRepository extends CrudRepository<Member, Integer> {
	
}
