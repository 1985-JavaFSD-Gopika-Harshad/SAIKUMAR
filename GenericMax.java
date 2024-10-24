package com.example.programs;
public class GenericMax {

  
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        T max = array[0]; 
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element; 
            }
        }
        return max; 
    }

    public static void main(String[] args) {
      
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Max Integer: " + findMax(intArray));

     
        String[] stringArray = {"apple", "banana", "cherry"};
        System.out.println("Max String: " + findMax(stringArray));
    }
}
