package entity;

public class Score {


	/**
	 * ������: ��Ŀ��: entity 2018��10��10��-����9:12:37
	 */
	private Integer stuid;// ѧ��ѧ��
	private Double grade;// �ɼ�
	private Integer courseid;// �κ�
	
	private String stuname;//����
	private Integer year;//���ѧ��
	private String name;//�γ���
	private Double credit;//�γ���
	
	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
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

	public Integer getCourseid() {
		return courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

}
