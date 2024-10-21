package com.example.programs;
import java.util.*;
public class MaintaingGrade {

	public static void main(String[] args) {

		LinkedHashMap<String, Integer> grades=new LinkedHashMap<>();

		grades.put("student01", 99);
		grades.put("student02", 98);
		grades.put("student03", 97);
		grades.put("student04",35);
		grades.put("student05", 96);
		grades.put("student06", 98);
		
		System.out.println(grades);
		
		for(String id:grades.keySet()) {
			System.out.println("Grade for "+id+" is : "+grades.get(id));
		}
		
		
	}

}