package com.xiaoshi.service.iface;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.xiaoshi.domain.User;

public interface UserService {

	public boolean checkUserNameAndPassword(String userName, String password);
	public boolean checkUserName(String userName);
	
	public List<Map<String,Object>> queryAllUserAndUserDetail();
	public Optional<Map<String,Object>> queryUserAndUserDetailById(int id);
	
	public boolean deleteUser(String ids);
	
	public Optional<User> getUser(int id);
	

	
}
