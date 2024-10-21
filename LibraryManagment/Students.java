package com.example.programs;
import java.util.*;
public class Students {
	public static void main(String[] args) {
		HashMap<String,Integer> grades=new HashMap<>();
		grades.put("saikumar",99);
		grades.put("raju",58);
		grades.put("Ravi",89);
		grades.put("kumar", 69);
	
		
		System.out.println("all students with grades :"+ grades);

		
		System.out.println("grade of student  : saikumar ="+grades.get("saikumar"));
		
		grades.put("saikumar",75);
		
		grades.remove("kumar");
		
		System.out.println("all students with grades :"+ grades);

	}
}

		
