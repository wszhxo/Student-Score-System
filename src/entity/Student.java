package entity;

import java.util.Date;

public class Student {
	/**
	 * ������:zhx ��Ŀ��: ѧ��ʵ���� 2018��10��10��-����9:02:43
	 */
	private Integer id;// ѧ�� ����
	private String name;// ����
	private String sex;// �Ա�
	private Date age;// ����
	private String address;// ��ַ
	private String depart;// ϵ��
	private String password;//����
	private Integer isdel;//�Ƿ�ɾ��1��ʾɾ��
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
