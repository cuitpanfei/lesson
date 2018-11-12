package com.pfinfo.lesson.example;

import java.util.List;
import java.util.function.Supplier;

import com.pfinfo.lesson.example.mapper.UserMapper;
import com.pfinfo.lesson.example.mapper.UserMapperImpl;
import com.pfinfo.util.bean.User;

/**
 * 示例代码运行主方法
 * @author pys1714
 *
 */
public class ExampleMain {

	
	public static void main(String[] args) {
		ExampleMain exampleMain = new ExampleMain();
		UserMapper userMapper = new UserMapperImpl();
		List<User> users= exampleMain.findAll(userMapper::findAll);

		users.stream()
		.forEach(System.out::println);
	}
	
	public <T> T findAll(Supplier<T> supplier){
		return supplier.get();
	}

}
