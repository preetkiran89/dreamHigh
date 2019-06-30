package programs.examples.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class EmployeeInfo 
{
	private int userId;
	private String fname;
	private String lname;
	private char gender;
	private String mobile;
	private String email_official;
	private String deptId;
	private String email;
	private Date date_of_joinig;
	private Address address;
	private String profileStatus;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail_official() {
		return email_official;
	}

	public void setEmail_official(String email_official) {
		this.email_official = email_official;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Date getDate_of_joinig() {
		return date_of_joinig;
	}

	public void setDate_of_joinig(Date date_of_joinig) {
		this.date_of_joinig = date_of_joinig;
	}

	public String getProfileStatus() {
		return profileStatus;
	}

	public void setProfileStatus(String profileStatus) {
		this.profileStatus = profileStatus;
	}

	@Override
	public String toString() {
		return "EmployeeInfo [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender
				+ ", mobile=" + mobile + ", email_official=" + email_official + ", deptId=" + deptId + "]";
	}

}
