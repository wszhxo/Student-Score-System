package entity;

public class Course {
	/**
	 * ������:zhx ��Ŀ��: �γ�ʵ���� 2018��10��10��-����9:15:04
	 */
	private Integer id;// ���� �γ̺�
	private String course;// �γ���
	private String ename;// Ӣ����
	private Double credit;//ѧ��
	private Integer year;//ѧ��
	
	private Integer stuid;
	private Double grade;//���Գɼ�
	
	public Integer getStuid() {
		return stuid;
	}

	public void setStuid(Integer stuid) {
		this.stuid = stuid;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
