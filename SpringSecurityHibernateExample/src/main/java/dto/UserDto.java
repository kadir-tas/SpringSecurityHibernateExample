package dto;

import java.sql.Date;

import com.sun.istack.NotNull;

import model.User;

public class UserDto {

	@NotNull
	private String username;

	@NotNull
	private String password;

	@NotNull
	private String passwordConfirm;
	
	@NotNull
	private boolean enabled;

	@NotNull
	private String email;

	@NotNull
	private Date birthday;

	private int sex;

	public UserDto() {
		
	}
	
	public UserDto(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.enabled = user.isEnabled();
		this.email = user.getEmail();
		this.birthday = user.getBirthday();
		this.sex = user.getSex();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return username;
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

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isEnabled() {
		return this.enabled;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}


}
