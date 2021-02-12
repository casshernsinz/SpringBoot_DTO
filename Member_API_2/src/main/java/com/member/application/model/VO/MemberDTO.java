package com.member.application.model.VO;

public class MemberDTO {
	
	private Integer id;
	
	private String firstName;
	private String lastName;
	private String DOB;
	private String address_1;
	private String address_2;
	private String city;
	private String state;
	private Boolean isActive;
	private String username;
	private String password;

	public MemberDTO() {}

	public MemberDTO(Integer id, String username, String password, String firstName, String lastName, String DOB,
			String address_1, String address_2, String city, String state) {

		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.DOB = DOB;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.city = city;
		this.state = state;

	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDOB() {
		return this.DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

	public String getAddress_1() {
		return address_1;
	}

	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	public String getAddress_2() {
		return this.address_2;
	}

	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return String.format("Member[ID=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
}
