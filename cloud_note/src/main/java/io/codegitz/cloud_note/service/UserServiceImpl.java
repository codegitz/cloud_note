package io.codegitz.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.codegitz.cloud_note.dao.UserDao;
import io.codegitz.cloud_note.entity.User;
import io.codegitz.cloud_note.util.NoteException;
import io.codegitz.cloud_note.util.NoteResult;
import io.codegitz.cloud_note.util.NoteUtil;

@Service("userService") // 扫描的spring容器
//@Transactional  //动态代理
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	public NoteResult<User> checkLogin(String name, String password) {
		// 接收查收结果数据
		NoteResult<User> result = new NoteResult<User>();
		// 按照参数name查询数据库
		User user = userDao.findByName(name);
		// 检查用户名
		if (user == null) {
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		// 检查密码
		String md5Password=null;
		try {
			md5Password = NoteUtil.md5(password);
		} catch (NoteException e) {
			e.printStackTrace();
		}
		if (!user.getCn_user_password().equals(md5Password)) {
			result.setStatus(2);
			result.setMsg("密码不正确");
			return result;
		}
		// 账户密码都正确
		result.setStatus(0);
		result.setMsg("登录成功");
		result.setData(user);
		return result;
	}

	public NoteResult<Object> addUser(String name, String password, String nick) {
		NoteResult<Object> result = new NoteResult<Object>();
        //用户检查
		User hasUser=userDao.findByName(name);
        if(hasUser!=null){//用户名不为空
        	result.setStatus(1);
        	result.setMsg("用户名已被占用");
        	return result;
        }
		//添加用户
        User user=new User();
		user.setCn_user_name(name);
		user.setCn_user_nick(nick);
		//设置密码
		String md5Password=null;
		try {
			md5Password = NoteUtil.md5(password);
		} catch (NoteException e) {
			e.printStackTrace();
		}
		user.setCn_user_password(md5Password);
		//创建ID
		String id=NoteUtil.createId();
		//设置id
		user.setCn_user_id(id);
		//插入用户数据
		userDao.save(user);
		//构建返回结果
		result.setStatus(0);
		result.setMsg("注册成功");
		return result;
		
	}

	
	

}
