package com.example.programs;

import java.util.List;
import java.util.Scanner;

public class BoundedType {
	 public static void printList(List<? extends Number> list) {
	        for (Number number : list) {
	            System.out.println(number);
	        }

}
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Select List Type to Print:");
	        System.out.println("1. List of Integers");
	        System.out.println("2. List of Doubles");
	        System.out.println("3. List of Floats");

	        int choice = scanner.nextInt();

	        switch (choice) {
	            case 1 -> {
	                List<Integer> integerList = List.of(10, 20, 30, 40);
	                System.out.println("Printing Integer List:");
	                printList(integerList);
	            }
	            case 2 -> {
	                List<Double> doubleList = List.of(10.5, 20.5, 30.5);
	                System.out.println("Printing Double List:");
	                printList(doubleList);
	            }
	            case 3 -> {
	                List<Float> floatList = List.of(1.2f, 2.3f, 3.4f);
	                System.out.println("Printing Float List:");
	                printList(floatList);
	            }
	            default -> System.out.println("Invalid choice");
	        }

	        scanner.close();
	    }
	}