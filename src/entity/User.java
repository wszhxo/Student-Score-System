package entity;

public class User {
	/**
	 * ������: ��Ŀ��: ��¼�û�ʵ���� 2018��10��10��-����9:08:57
	 */
	private Integer id;// ����
	private String username;// ѧ�� �û���
	private String password;// ����
	private Integer type;//���ѧ��������ʦ
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
