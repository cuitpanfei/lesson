package com.pfinfo.lesson.code;

public class Main {

	public static void main(String[] args){
		CopyOfUnaryOperator<Integer> tmp = t -> t*2;
		System.out.println(tmp.identity());
	} 
}
