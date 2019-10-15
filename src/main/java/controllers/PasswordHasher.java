package controllers;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {
	
	private final static String SALT = "miniMax";
	
	public String hash (String password)throws NoSuchAlgorithmException  {
		password += SALT;
		MessageDigest md5=MessageDigest.getInstance("MD5");
		md5.update(StandardCharsets.UTF_8.encode(password));
		return String.format("%032x",new BigInteger (md5.digest()));
		
	}

}
