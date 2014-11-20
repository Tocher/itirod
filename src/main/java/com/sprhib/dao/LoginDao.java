package com.sprhib.dao;

import com.sprhib.model.Users;



public interface LoginDao {
	Users findByUserName(String username);
}
