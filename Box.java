package com.example.programs;
public class Box<T> {

    private T value; 
  
    public Box(T value) {
        this.value = value;
    }

    public void display() {
       
        System.out.println("Type: " + value.getClass().getName());
        System.out.println("Value: " + value);
    }

    public static void main(String[] args) {
     
        Box<Integer> intBox = new Box<>(123);
        intBox.display();

        Box<String> strBox = new Box<>("Hello World");
        strBox.display();

        Box<Double> dblBox = new Box<>(99.99);
        dblBox.display();
    }
}

