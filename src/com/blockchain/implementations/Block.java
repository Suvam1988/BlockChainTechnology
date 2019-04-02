package com.blockchain.implementations;

import java.util.Arrays;
import java.util.Date;

public class Block {
	
	public String previousHash;
	private String data;
	private long timeStamp;
	public String hash;
	
	public Block(String data, String previousHash) throws Exception {
		
		this.data=data;
		this.previousHash=previousHash;
		this.timeStamp = new Date().getTime();
		this.hash=calculateHash();
	}
	
	public String calculateHash() throws Exception {
	    String calculatedhash = StringUtils.applySHA256( 
	            previousHash +
	            Long.toString(timeStamp) +
	            data 
	            );
	    return calculatedhash;
	}

}
