package com.pfinfo.lesson.example;

public class LambdaExample {

	public static void main(String[] args) {
		LambdaExample example=new LambdaExample();
		
		example.lambdaCodeTest();
	}
	
	public void lambdaCodeTest(){
//		String name="LambdaExample";
		/** jdk1.8之前 */
		Runnable r1 = new Runnable() {
			public void run() {
				String name="r1";
				System.out.println("Hello "+name+" "+this.getClass());
			}
		};
		/** jdk1.8之后 */
		Runnable r2 = () -> {
			String name="r2";
			System.out.println("Hello "+name+" "+this.getClass());
		};
		
		new Thread(r1).start();
		new Thread(r2).start();
	}
}
