package test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.codegitz.cloud_note.dao.UserDao;
import io.codegitz.cloud_note.entity.User;
import io.codegitz.cloud_note.service.UserService;
import io.codegitz.cloud_note.util.NoteResult;

public class TestUserService {
	UserService service;
	@Before
	public void init(){
		String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml","conf/spring-transaction.xml"};
		ApplicationContext ctx=new ClassPathXmlApplicationContext(conf);
        UserDao dao=ctx.getBean("userDao",UserDao.class);
        service=ctx.getBean("userService",UserService.class);
	}
	@Test
	//用例 -1 预期结果：用户名不存在
	public void testUserService1(){
		NoteResult<User> result=service.checkLogin("algihj", "awt");
		System.out.println(service.getClass().getName());
	/*	System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		System.out.println(result.getData());*/
	}
	@Test
	public void testUserService2(){
		User user=new User();
		user.setCn_user_name("sally");
		user.setCn_user_nick("sa~");
		user.setCn_user_password("123345");
		NoteResult<Object> result=service.addUser(user.getCn_user_name(),user.getCn_user_password()
				,user.getCn_user_nick());
		System.out.println(result.getStatus());
		System.out.println(result.getMsg());
		System.out.println(result.getData());
	}
	@Test
	public void testUserService3(){
		
	}
	
       
}
