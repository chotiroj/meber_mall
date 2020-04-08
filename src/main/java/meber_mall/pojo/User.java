package meber_mall.pojo;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String phone_num;
	private Integer m_grade;
	private String address;
	private double user_jf;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public Integer getM_grade() {
		return m_grade;
	}
	public double getUser_jf() {
		return user_jf;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	
	public void setM_grade(Integer m_grade) {
		this.m_grade = m_grade;
	}
	public void setUser_jf(double user_jf) {
		this.user_jf = user_jf;
	}
	
}
