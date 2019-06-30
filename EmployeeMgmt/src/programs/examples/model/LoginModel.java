package programs.examples.model;

public class LoginModel 
{
	private int userid;
	private String password_hash;
	private long user_created_date;
	private long last_login_date;
	private String email;
	private int first_login;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPassword_hash() {
		return password_hash;
	}

	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}

	public long getUser_created_date() {
		return user_created_date;
	}

	public void setUser_created_date(long user_created_date) {
		this.user_created_date = user_created_date;
	}

	public long getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(long last_login_date) {
		this.last_login_date = last_login_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFirst_login() {
		return first_login;
	}

	public void setFirst_login(int first_login) {
		this.first_login = first_login;
	}

	@Override
	public String toString() {
		return "LoginModel [userid=" + userid + ", user_created_date="
				+ user_created_date + ", last_login_date=" + last_login_date + ", email=" + email + "]";
	}

}
