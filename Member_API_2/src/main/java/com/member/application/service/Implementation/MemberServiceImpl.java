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

	Member member = new Member();
	
	public MemberDTO createMember(MemberDTO memberDTO) {
		
		memberDTO.setIsActive(true);
		
		member = modelMapper.map(memberDTO, Member.class);
		
		try {
			
			System.out.println(">>>>>>>>>>>>>>Inside the TRY");			
			memberRepo.save(member);			
			System.out.println(">>>>>>>>>>>>>>TRY succeeded!!!!");

		}

		catch (Exception e) {
			System.out.println("Inside the CATCH...Here is the MEMBER-DTO object for testing --> " + memberDTO);
			System.out.println(e);
		}

		return memberDTO;
	}

	public List<MemberDTO> findAllMembers() {

		List<MemberDTO> members = new ArrayList<MemberDTO>();
		
		try {
			memberRepo.findAll().forEach(m -> members.add(modelMapper.map(m, MemberDTO.class)));			
			System.out.println("Inside the TRY");
			System.out.println(members);
		}

		catch (Exception e) {
			System.out.println("Inside the CATCH" + e);
		}
		
		System.out.println("This is the RETURN");
		return members;
	}

	/*
	 * public MemberDTO findMember(Integer id) {
	 * 
	 * try { Optional<Member> member = memberRepo.findById(id); if
	 * (member.isPresent()) { MemberDTO memberVO = convertToVO(member.get()); return
	 * memberVO; } } catch (Exception e) { // diagnostic System.out.println(e); }
	 * return null; }
	 * 
	 * public MemberDTO deactivateMember(Integer id) { // create member
	 * Optional<Member> member = memberRepo.findById(id);
	 * 
	 * if (member.isPresent()) { Member memberToDeactivate = member.get();
	 * memberToDeactivate.setIsActive(false); memberRepo.save(memberToDeactivate);
	 * return convertToVO(memberToDeactivate);
	 * 
	 * } return null; }
	 */

	/*
	 * private Member convertToMember(MemberDTO memberVO) { Member member = new
	 * Member(); member.setId(memberVO.getId());
	 * member.setUsername(memberVO.getUsername());
	 * member.setPassword(memberVO.getPassword());
	 * member.setFirstName(memberVO.getFirstName());
	 * member.setLastName(memberVO.getLastName()); member.setDOB(memberVO.getDOB());
	 * member.setAddress_1(memberVO.getAddress_1());
	 * member.setAddress_2(memberVO.getAddress_2());
	 * member.setCity(memberVO.getCity()); member.setState(memberVO.getState());
	 * member.setIsActive(memberVO.getIsActive()); return member; }
	 * 
	 * private MemberDTO convertToVO(Member member) { MemberDTO memberVO = new
	 * MemberDTO(); memberVO.setId(member.getId());
	 * memberVO.setFirstName(member.getFirstName());
	 * memberVO.setLastName(member.getLastName());
	 * memberVO.setUsername(member.getUsername());
	 * memberVO.setPassword(member.getPassword()); memberVO.setDOB(member.getDOB());
	 * memberVO.setAddress_1(member.getAddress_1());
	 * memberVO.setAddress_2(member.getAddress_2());
	 * memberVO.setCity(member.getCity()); memberVO.setState(member.getState());
	 * memberVO.setIsActive(member.getIsActive()); return memberVO; }
	 */

}
