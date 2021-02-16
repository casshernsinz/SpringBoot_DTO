package com.member.application.api;

import java.util.List;
import java.util.Optional;

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

	@PostMapping(path = "/members")
	@ResponseStatus(HttpStatus.CREATED)
	public MemberDTO createNewMember(@RequestBody MemberDTO member) {

		memberService.createMember(member);

		return member;
	}

	@GetMapping(path = "/members")
	public List<MemberDTO> getAllMembers() {

		return memberService.findAllMembers();
	}

	@GetMapping(path = "/members/{id}")
	@Cacheable("members")
	public MemberDTO findMember(@PathVariable Integer id) {

		return memberService.findMember(id);
	}

	@PutMapping("members/deactivate/{id}")
	public ResponseEntity<String> deactivateAccount(@PathVariable Integer id) {
		
		MemberDTO memberToDeactivate = memberService.deactivateMember(id);
		
		if(memberToDeactivate.getIsActive() == false) {
			return new ResponseEntity<String>("Sucessfully Deactivated Account", HttpStatus.OK);
		}
				
		return new ResponseEntity<String>("Member still active.", HttpStatus.BAD_REQUEST);
	}
}
