package com.dawidzjava.SpringHellpDesk.service;


import com.dawidzjava.SpringHellpDesk.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

}
