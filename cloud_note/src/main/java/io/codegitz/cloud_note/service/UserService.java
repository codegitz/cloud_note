package io.codegitz.cloud_note.service;

import io.codegitz.cloud_note.entity.User;
import io.codegitz.cloud_note.util.NoteResult;

public interface UserService {
    //检查登录  
	public NoteResult<User> checkLogin(String name,String password);
    //检查注册
	public NoteResult<Object> addUser(String name,String password,String nick);
      
}
