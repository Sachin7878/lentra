package com.lentra.ai.dto;

public class UserRequest {

	private String firstName;

	private String lastName;

	private String email;

	private String mobileNo;

	public UserRequest() {
		super();
	}

	public UserRequest(String firstName, String lastName, String email, String mobileNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "UserRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", mobileNo="
				+ mobileNo + "]";
	}

}
