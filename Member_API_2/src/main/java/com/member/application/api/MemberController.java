package com.member.application.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.member.application.model.Member;
import com.member.application.model.VO.MemberDTO;
import com.member.application.service.Implementation.MemberServiceImpl;

@RestController
public class MemberController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@PostMapping(path = "/addMembers" )
	@ResponseStatus(HttpStatus.CREATED)
	public MemberDTO createNewMember(@RequestBody MemberDTO member) {
		
		System.out.println("Creating Member...");
		
		memberService.createMember(member);
		
		System.out.println("Member is Created...");
		
		return member;		
	}
	
	@GetMapping(path = "/members")
	public Iterable<MemberDTO> getAllMembers(){
		
		System.out.println("Inside the getAllMembers Controller");
		
		return memberService.findAllMembers();
	}
	
	/*
	 * @GetMapping(path = "/members/{id}")
	 * 
	 * @Cacheable("members") public MemberDTO findMember(@PathVariable Integer id){
	 * MemberDTO member = new MemberDTO(); try { member =
	 * memberService.findMember(id); }
	 * 
	 * catch(Exception e){ System.out.println(e); }
	 * 
	 * return member; }
	 * 
	 * @PutMapping("members/deactivate/{id}") public ResponseEntity<String>
	 * deactivateAccount(@PathVariable Integer id) { MemberDTO memberToDeactivate =
	 * memberService.deactivateMember(id); if(memberToDeactivate.getIsActive() ==
	 * false) { return new ResponseEntity<String>("Sucessfully Deactivated Account",
	 * HttpStatus.OK); }
	 * 
	 * //unsure if this is the best response to send. return new
	 * ResponseEntity<String>("Member still active.", HttpStatus.BAD_REQUEST); }
	 */

}
