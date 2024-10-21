package com.example.programs;





class Pair<T,U>{
	private T first;
	private U second;
	public Pair(T first, U second) {
		super();
		this.first = first;
		this.second = second;
	}
	public T getFirst() {
		return first;
	}
	public void setFirst(T first) {
		this.first = first;
	}
	public U getSecond() {
		return second;
	}
	public void setSecond(U second) {
		this.second = second;
	}
	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}
	public Pair() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
public class GenericPairClass {

	public static void main(String[] args) {
		Pair<Integer,String> pair=new Pair<>(1,"saikumar");
		System.out.println("First : "+pair.getFirst());
		System.out.println("Second : "+pair.getSecond());
		
		pair.setFirst(99);
		pair.setSecond("Hello");
		System.out.println(pair.toString());
	}

	

}
