package io.codegitz.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.codegitz.cloud_note.entity.User;
import io.codegitz.cloud_note.service.UserService;
import io.codegitz.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserLoginController {
      @Resource
      private UserService userService;
       @RequestMapping("/login.do")
       @ResponseBody
      public NoteResult<User> execute(String name,String password){
    	  //调用UserService处理登录请求
    	   System.out.println(name+","+password);
    	   NoteResult result=userService.checkLogin(name, password);
    	  return result;
      } 
}
