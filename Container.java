package com.example.programs;

import java.util.Scanner;

public class Container<T> {
	private T object;
	
	public void set(T object) {
		this.object=object;
	}
	public T get() {
		return object;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Select Container Type:");
        System.out.println("1. Integer");
        System.out.println("2. String");
        System.out.println("3. Double");
        
        int choice=sc.nextInt();
        sc.nextLine();
        switch (choice) {
        case 1 -> {
            Container<Integer> intContainer = new Container<>();
            System.out.println("Enter an Integer:");
            int value = sc.nextInt();
            intContainer.set(value);
            System.out.println("Stored Integer: " + intContainer.get());
        }
        case 2 -> {
            Container<String> stringContainer = new Container<>();
            System.out.println("Enter a String:");
            String value = sc.nextLine();
            stringContainer.set(value);
            System.out.println("Stored String: " + stringContainer.get());
        }
        case 3 -> {
            Container<Double> doubleContainer = new Container<>();
            System.out.println("Enter a Double:");
            double value = sc.nextDouble();
            doubleContainer.set(value);
            System.out.println("Stored Double: " + doubleContainer.get());
        }
        default -> System.out.println("Invalid choice");
    }

    sc.close();
}
}