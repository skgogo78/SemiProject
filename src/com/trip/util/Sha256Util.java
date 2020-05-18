package com.trip.util;

import java.security.MessageDigest;

public class Sha256Util {

	public static String encSha256(String pw) {
		String returnVal = new String();

		try{

			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(pw.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}

			//출력
			returnVal = hexString.toString();

		} catch(Exception ex){
			throw new RuntimeException(ex);
		}
		
		return returnVal;
	}

	public static void main(String[] args) {
		
		System.out.println(encSha256("123123"));
		
	}
	
}

