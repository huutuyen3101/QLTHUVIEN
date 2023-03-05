package model;


import java.util.Date;
import java.util.Objects;

public class User {
	private String UserName;
	private String Password;
	private String FullName;
	private String Sex;
	private String Email;
	private String Roles;
	private Date date;
	private String Phone;
	
	
	
	public User(String userName, String password,String FullName, String sex, String email,String roles,Date date,String phone) {
		this.UserName = userName;
		this.Password = password;
		this.FullName = FullName;
		this.Sex = sex;
		this.Email  = email;
		this.Roles = roles;
		this.date = date;
		this.Phone =phone;
	}

	
	public User ()
	{}
	@Override
	public String toString() {
		return "User [UserName=" + UserName + ", Password=" + Password + ", FullName=" + FullName + ", Sex=" + Sex
				+ ", Email=" + Email + ", Roles=" + Roles + ", date=" + date + ", Phone=" + Phone + "]";
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getRoles() {
		return Roles;
	}
	public void setRoles(String roles) {
		Roles = roles;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date1) {
		
		this.date = date1;
	}


	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(Email, other.Email) && Objects.equals(FullName, other.FullName)
				&& Objects.equals(Password, other.Password) && Objects.equals(Phone, other.Phone)
				&& Objects.equals(Roles, other.Roles) && Objects.equals(Sex, other.Sex)
				&& Objects.equals(UserName, other.UserName) && Objects.equals(date, other.date);
	}

	
	
	
	
}
