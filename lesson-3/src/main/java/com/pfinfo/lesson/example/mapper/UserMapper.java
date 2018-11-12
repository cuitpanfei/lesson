package com.pfinfo.lesson.example.mapper;

import java.util.List;

import com.pfinfo.util.bean.User;
import com.pfinfo.util.exception.CustomException;

public interface UserMapper {
	
	User selectUserByID(Integer id);
    
    List<User> selectUsersByName(String userName);
    
    void addUser(User user) throws CustomException;
    
    void updateUser(User user) throws CustomException;
    
    void deleteUser(Integer id) throws CustomException;
    
    List<User> findAll();
    
    default boolean checkById(Integer id){
    	return findAll().stream().filter(u->u.getId()==id).count()>0;
    }
}
