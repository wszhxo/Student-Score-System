package entity;

public class User {
	/**
	 * 创建人: 项目名: 登录用户实体类 2018年10月10日-下午9:08:57
	 */
	private Integer id;// 主键
	private String username;// 学号 用户名
	private String password;// 密码
	private Integer type;//类别学生还是老师
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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


}
