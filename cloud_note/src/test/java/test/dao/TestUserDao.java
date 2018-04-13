package test.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.codegitz.cloud_note.dao.UserDao;
import io.codegitz.cloud_note.entity.User;

public class TestUserDao {
	@Test
     public void testUserDao(){
    	 ApplicationContext ctx=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
         UserDao dao=ctx.getBean("userDao",UserDao.class);
         User user=dao.findByName("demo");
         List<User> user1=dao.findAll();
         System.out.println(user1);
     }
	@Test
	public void testSave(){
		String[] conf={"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
		//实例化ctx对象
		ApplicationContext ctx=new ClassPathXmlApplicationContext(conf);
		//获取UserDao对象
		UserDao dao=ctx.getBean("userDao",UserDao.class);
		User user =new User();
		user.setCn_user_id("1234");
		user.setCn_user_name("张三丰");
		user.setCn_user_password("123456");
		user.setCn_user_nick("君宝");
		dao.save(user);
		System.out.println(user);
		
	}
}
