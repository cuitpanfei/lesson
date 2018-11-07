package com.pfinfo.lesson.defaultmethod;

public class DefaultMethod {

	public static void main(String[] args) {

		CollectionInterface defaultMethod = new CollectionInterface(){
			@Override
			public String showMsg() {
				return null;
			}
		};
		System.out.println(defaultMethod.showMsg());
		defaultMethod.addOneObj(null);
	}

}
