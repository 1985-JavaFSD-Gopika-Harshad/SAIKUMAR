package com.example.programs;
import java.util.*;

public class UniqueUserName {

	public static void main(String[] args) {
	HashSet<String> unique=new HashSet<>();
	
	unique.add("saikumar");
	unique.add("saicharan");
	unique.add("rajesh");
	String checkUserName="saikumar";
	if(unique.contains(checkUserName)) {
		System.out.println(checkUserName+" "+"already exist");
		
	}
	else {
		System.out.println(checkUserName+" "+"not exist");
	}
	unique.remove("rajesh");
	System.out.println(unique);
	

	}

}
