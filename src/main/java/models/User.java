package models;

public class User {
	private long id;
	private String login;
	private String password;
	private String name;
	private String region;
	private int gender;
	private String comment;
	public User() {
		super();
		this.gender = 47;
	}
	public User(long id, String login, String password, String name, String region, int gender, String comment) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
		this.region = region;
		this.gender = gender;
		this.comment = comment;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
