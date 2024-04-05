package com.dawidzjava.SpringHellpDesk.dao;


import com.dawidzjava.SpringHellpDesk.entity.User;

public interface UserDao {


    public void save(User user);
    User findByUserName(String userName);
    
}
