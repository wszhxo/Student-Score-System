package entity;

public class Course {
	/**
	 * 创建人:zhx 项目名: 课程实体类 2018年10月10日-下午9:15:04
	 */
	private Integer id;// 主键 课程号
	private String course;// 课程名
	private String ename;// 英文名
	private Double credit;//学分
	private Integer year;//学年
	
	private Integer stuid;
	private Double grade;//回显成绩
	
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
