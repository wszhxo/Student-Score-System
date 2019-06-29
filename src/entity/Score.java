package entity;

public class Score {


	/**
	 * 创建人: 项目名: entity 2018年10月10日-下午9:12:37
	 */
	private Integer stuid;// 学生学号
	private Double grade;// 成绩
	private Integer courseid;// 课号
	
	private String stuname;//姓名
	private Integer year;//年份学年
	private String name;//课程名
	private Double credit;//课程名
	
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
