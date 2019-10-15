package controllers;

public class Check {

	public static final int a = 97;
	public static final int z = 122;
	public static final int A = 65;
	public static final int Z = 90;

	public Check() {

	}

	public boolean checkPsw(String password, String rePsw) {

		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";

		if (password != null && rePsw != null && password.length() != 0 && rePsw.length() != 0 && password.equals(rePsw))
			return password.matches(pattern);
		return false;

	}

	public boolean checkEmail(String email) {
		String pattern = "^[a-zA-Z0-9.!#$%&*+/=?^_'{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		
		if(email != null && email.length() != 0)
			return email.matches(pattern);
		return false;
	}
	
	public boolean checkName(String name) {
		String pattern = "[a-zA-Z]+";
		
		if(name != null && name.length() != 0)
			return name.matches(pattern);
		return false;
	}
	
	public boolean checkRegion(String region) {
		if(region != null && region.length() != 0)
			return false;
		return true;
	}
	
	public boolean checkGender(String gender) {
		if(gender != null && gender.length() != 0)
			return false;
		return true;
	}
	
	public boolean checkComment(String comment) {
		if(comment != null && comment.length() != 0)
			return false;
		return true;
	}
	
	public boolean checkRegParams(String login, String password, String rePsw, String name, String region, String gender, String comment) {
		boolean err = false;
		if(checkEmail(login))
			err =true;
		if(checkPsw(password, rePsw))
			err = true;
		if(checkName(name))
			err = true;
		if(checkRegion(region))
			err = true;
		if(checkGender(gender))
			err = true;
		if(checkComment(comment))
			err = true;
		
		return err;
	}
}
