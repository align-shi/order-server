package com.xiaoshi.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshi.config.UnifyResponse;
import com.xiaoshi.domain.FeedbackDTO;
import com.xiaoshi.domain.OrderDetail;
import com.xiaoshi.domain.User;
import com.xiaoshi.domain.WeChatUser;
import com.xiaoshi.dto.EditUserDTO;
import com.xiaoshi.mapper.UserMapper;
import com.xiaoshi.mapper.UserNewMapper;
import com.xiaoshi.service.iface.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Transactional
@Service
@Log4j2
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Autowired
	private UserNewMapper userNewMapper;


	@Override
	public boolean checkUserNameAndPassword(String userName, String password) {
		boolean flag=false;
		User user=userMapper.queryUserByNameAndPassword(userName,password);
		if(null!=user){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean checkUserName(String userName) {
		return false;
	}

	@Override
	public List<Map<String, Object>> queryAllUserAndUserDetail() {
		return null;
	}

	@Override
	public Optional<Map<String, Object>> queryUserAndUserDetailById(int id) {
		return Optional.empty();
	}

	@Override
	public boolean deleteUser(String ids) {
		return false;
	}

	@Override
	public Optional<User> getUser(int id) {
		return Optional.empty();
	}

	@Override
	public UnifyResponse<Object> saveUserInfo(WeChatUser weChatUser) {
		userMapper.saveWechatUser(weChatUser);
		return UnifyResponse.success();
	}

	@Override
	public UnifyResponse<Object> getUserInfo(String username) {
		return UnifyResponse.success(userMapper.getUserInfo(username));
	}

	@Override
	public UnifyResponse<Object> feedback(FeedbackDTO feedbackDTO) {
		userMapper.saveFeedback(feedbackDTO);
		return UnifyResponse.success();
	}

	@Override
	public UnifyResponse<Object> getFeedBack(Integer pageSize, Integer pageNo, String username) {
		PageHelper.startPage(pageNo, pageSize);
		final List<Map<String, Object>> maps = userNewMapper.queryFeedback(username);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		maps.forEach(map ->{
			Timestamp time = (Timestamp) map.get("create_time");
			map.put("create_time",df.format(time));
		});
		return UnifyResponse.success(new PageInfo<>(maps));
	}

	@Override
	public UnifyResponse<Object> getUserList(Integer pageSize, Integer pageNo,String username) {
		PageHelper.startPage(pageNo, pageSize);
		List<Map<String, Object>> maps = userNewMapper.queryAllUser(username);
		return UnifyResponse.success(new PageInfo<>(maps));
	}

	@Override
	public UnifyResponse<Object> editVipInfo(EditUserDTO editUserDTO) {
		userNewMapper.update(editUserDTO);
		return UnifyResponse.success();
	}
}
