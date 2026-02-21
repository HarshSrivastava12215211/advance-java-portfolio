package com.prac;

public class UserService {
	
	UsersDAO dao; // null
	
	UserService(UsersDAO dao)
	{
		this.dao = dao;
	}
	
	public String typeOfUser(int id) {
		// TODO Auto-generated method stub
		
		Users user = dao.findById(id);
		
		
		if(user.getBalance() >= 0 && user.getBalance() <= 1000)
		{
			return "new User";
		}
		else if(user.getBalance() >= 1001 && user.getBalance() <= 2000)
		{
			return "regular user";
		}
		else
		{
			return "premium user";
		}

	}

}
