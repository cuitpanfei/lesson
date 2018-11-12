package com.pfinfo.lesson.example;

import java.util.function.Consumer;

import com.pfinfo.util.bean.User;

/**
 * Consumer函数式接口示例代码
 * @author pys1714
 *
 */
public class ConsumerInterfaceExample {
	
	private static final Consumer<User> consumerImpl =  user -> {
		System.out.println(user.toString());
	};
	
	public static void info(User user){
		consumerImpl.accept(user);
	}

}
