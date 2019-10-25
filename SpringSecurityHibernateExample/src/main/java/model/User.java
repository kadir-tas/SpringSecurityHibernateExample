package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dto.UserDto;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@Column
	private String email;

	@Column
	private Date birthday;

	@Column
	private int sex;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Authorities> authorities = new HashSet();

	public void setAuthorities(Set authorities) {
		this.authorities = authorities;
	}

	public User(UserDto userDto) {
		super();
		this.username = userDto.getUsername();
		this.password = userDto.getPassword();
		this.enabled = userDto.isEnabled();
		this.email = userDto.getEmail();
		this.birthday = userDto.getBirthday();
		this.sex = userDto.getSex();
	}

	public Set<Authorities> getAuthorities() {
		return authorities;
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
}