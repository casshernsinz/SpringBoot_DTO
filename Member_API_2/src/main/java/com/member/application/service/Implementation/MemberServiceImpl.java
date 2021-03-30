package com.member.application.service.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.member.application.repo.MemberRepository;
import com.member.application.model.Member;
import com.member.application.model.VO.MemberDTO;

@Service

public class MemberServiceImpl {

	@Autowired
	MemberRepository memberRepo;

	ModelMapper modelMapper = new ModelMapper();

	public MemberDTO createMember(MemberDTO memberDTO) {
		
		Member memberObj = new Member();
		
		memberDTO.setIsActive(true);

		memberObj = modelMapper.map(memberDTO, Member.class);

		memberRepo.save(memberObj);

		return memberDTO;
	}

	public List<MemberDTO> findAllMembers() {

		List<MemberDTO> members = new ArrayList<MemberDTO>();

		memberRepo.findAll().forEach(m -> members.add(modelMapper.map(m, MemberDTO.class)));

		return members;
	}

	public MemberDTO findMember(Integer id) {
		
		MemberDTO memberDTO = new MemberDTO();
		
		Optional<Member> member = memberRepo.findById(id);
		
		if(member.isPresent()) {			
			modelMapper.map(member.get(), memberDTO);						
		}
		
		return memberDTO;
	}

	public MemberDTO deactivateMember(Integer id) {
		
		Optional<Member> member = memberRepo.findById(id);
		MemberDTO memberDTO = new MemberDTO();

		if (member.isPresent()) {
			
			Member memberToDeactivate = member.get();
			
			memberToDeactivate.setIsActive(false);
			
			memberRepo.save(memberToDeactivate);
			
			memberDTO = modelMapper.map(memberToDeactivate, MemberDTO.class);
			
		}
		
		return memberDTO;
	}
	
	public MemberDTO reactivateMember(Integer id) {
		
		Optional<Member> member = memberRepo.findById(id);
		
		if(member.isPresent()) {
			
			Member deactivatedMember = member.get();
			
			deactivatedMember.setIsActive(true);
			
			memberRepo.save(deactivatedMember);
			
			return modelMapper.map(deactivatedMember, MemberDTO.class);

		}
		
		return null;
	}

}
