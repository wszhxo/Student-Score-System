package entity;

import java.util.Date;

public class Student {
	/**
	 * 创建人:zhx 项目名: 学生实体类 2018年10月10日-下午9:02:43
	 */
	private Integer id;// 学号 主键
	private String name;// 姓名
	private String sex;// 性别
	private Date age;// 年龄
	private String address;// 地址
	private String depart;// 系别
	private String password;//密码
	private Integer isdel;//是否删除1表示删除
	private Integer type;
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIsdel() {
		return isdel;
	}

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getAge() {
		return age;
	}

	public void setAge(Date age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	
}
