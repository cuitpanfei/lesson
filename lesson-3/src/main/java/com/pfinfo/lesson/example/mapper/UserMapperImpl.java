package com.pfinfo.lesson.example.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import com.pfinfo.util.StringUtil;
import com.pfinfo.util.bean.User;
import com.pfinfo.util.exception.CustomException;

public class UserMapperImpl implements UserMapper {
	
	private static final List<User> DB = new ArrayList<User>();
	
	public UserMapperImpl(){
		initDB();
	}

	@Override
	public User selectUserByID(Integer id) {
		return DB.stream().filter(u->u.getId()==id).findFirst().get();
	}

	private static void initDB() {
		int i=1;
		while(i<100){
			DB.add(new User(i,StringUtil.createUserName(),StringUtil.uuid()));
			i++;
		}
		DB.add(new User(Integer.MIN_VALUE,"admin","admin"));
	}

	@Override
	public List<User> selectUsersByName(String userName) {
		return DB.stream().filter(u->u.getUserName()==userName).collect(Collectors.toList());
	}

	@Override
	public void addUser(User user) throws CustomException {
		if(null==user.getId()){
			user.setId((int) DB.stream().count());
		}else{
			long size = DB.stream().filter(u->u.getId()==user.getId()).count();
			if(size>0){
				throw new CustomException("唯一索引重复");
			}
		}
		DB.add(user);
	}

	@Override
	public void updateUser(User user) throws CustomException {
		Integer id = user.getId();
		if(checkById(id)){
			DB.removeIf(u->u.getId()==id);
		}else{
			throw new CustomException("id 为"+id+"的数据不存在");
		}
		UnaryOperator<User> operator = u -> {
			if(u.getId()==id){
				return user;
			}
			return u;
		};
		DB.replaceAll(operator);
	}

	@Override
	public void deleteUser(Integer id) throws CustomException {
		if(checkById(id)){
			DB.removeIf(u->u.getId()==id);
		}else{
			throw new CustomException("id 为"+id+"的数据不存在");
		}
	}

	@Override
	public List<User> findAll() {
		return DB.stream().collect(Collectors.toList());
	}

}
