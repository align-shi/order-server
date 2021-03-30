package com.xiaoshi.service.iface;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.xiaoshi.config.UnifyResponse;
import com.xiaoshi.domain.FeedbackDTO;
import com.xiaoshi.domain.User;
import com.xiaoshi.domain.WeChatUser;
import com.xiaoshi.dto.EditUserDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {

	public boolean checkUserNameAndPassword(String userName, String password);
	public boolean checkUserName(String userName);
	
	public List<Map<String,Object>> queryAllUserAndUserDetail();
	public Optional<Map<String,Object>> queryUserAndUserDetailById(int id);
	
	public boolean deleteUser(String ids);
	
	public Optional<User> getUser(int id);

	UnifyResponse<Object> saveUserInfo(WeChatUser weChatUser);

	UnifyResponse<Object> getUserInfo(String username);

	UnifyResponse<Object> feedback(FeedbackDTO feedbackDTO);

	UnifyResponse<Object> getFeedBack(Integer pageSize, Integer pageNo, String username);

	UnifyResponse<Object> getUserList(Integer pageSize, Integer pageNo,String username);

	UnifyResponse<Object> editVipInfo(EditUserDTO editUserDTO);
	
}
