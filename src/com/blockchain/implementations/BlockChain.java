package com.blockchain.implementations;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;


public class BlockChain {
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>();

	public static void main(String[] args) throws Exception {
		
		System.out.println("...............Elements in side blocks.....................");
		Block genesisblock=new Block("Genesis block", "0");
		System.out.println("Hash for Block 1: "+ genesisblock.hash);
		
		
		Block secondBlock = new Block("Yo im the second block",genesisblock.hash);
		System.out.println("Hash for block 2 : " + secondBlock.hash);
		
		
		Block thirdBlock = new Block("Hey im the third block",secondBlock.hash);
		System.out.println("Hash for block 3 : " + thirdBlock.hash);
		
		
		
		Block secondBlockmod = new Block("Yes im the second block",genesisblock.hash);
		System.out.println("Hash for block 2 : " + secondBlock.hash);
		
		//...............Making a chain of blocks.....................
		
		blockchain.add(genesisblock);
		blockchain.add(secondBlock);
		blockchain.add(thirdBlock);
		
		System.out.println("...............Block Chain.....................");
		for(Block blk:blockchain){
			System.out.println(blk.hash);
		}
		
		System.out.println("...........Blocks in readable json format................");
		
	//	String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
//		System.out.println(blockchainJson);
		
		
		blockchain.remove(blockchain.indexOf(secondBlock));
		blockchain.add(secondBlockmod);
		
		
		
		
		
		
		
		isChainValid();
		
		
		

	}
	
	public static Boolean isChainValid() throws Exception {
		Block currentBlock; 
		Block previousBlock;
		
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			//compare registered hash and calculated hash:
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
		}
		return true;
	}

}
