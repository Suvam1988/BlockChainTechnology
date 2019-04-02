package com.blockchain.implementations;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {

	public static String applySHA256(String Input) throws Exception{
		
		
		
			MessageDigest digest=MessageDigest.getInstance("SHA-256");		
		
			byte hash[]=digest.digest(Input.getBytes("UTF-8"));
			
			StringBuffer hexString=new StringBuffer();
			for(int i=0;i<hash.length;i++){
				String hex=Integer.toHexString(0Xff+hash[i]) ;
				if(hex.length()==1)
					hexString.append('0');
				
				hexString.append(hex);
				
				
			}
		
		
		return hexString.toString();
		
	}
	
}
