package test.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.codegitz.cloud_note.dao.BookDao;
import io.codegitz.cloud_note.entity.Book;
import io.codegitz.cloud_note.util.NoteUtil;

public class TestBookDao {
	 String[] conf={"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
     ApplicationContext ctx=new ClassPathXmlApplicationContext(conf);
     @Test
     public void testDao(){
    	 BookDao dao=ctx.getBean("bookDao",BookDao.class);
    	 NoteUtil util=new NoteUtil();
    	 Book addBook=new Book();
    	 for(int i=0;i<5;i++){
    	 addBook.setCn_notebook_id(util.createId());
    	 addBook.setCn_notebook_name("test"+i);
    	 System.out.println(addBook.getCn_notebook_id()+","+addBook.getCn_notebook_name());
    	 dao.save(addBook);
    	 }
         /*List<Book> lists = dao.findByUserId("");
         for(Book book:lists){
        	 System.out.println(book.getCn_notebook_id()+","+book.getCn_notebook_name());
         }*/
     }
     @Test
     public void testAddBook(){
    	 BookDao dao=ctx.getBean("bookDao",BookDao.class);
    	 Book book =new Book();
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	 String time = df.format(new Date());
    	 Timestamp ts = Timestamp.valueOf(time);
    	 book.setCn_notebook_name("这是一个新建的笔记本名字");
    	 book.setCn_user_id("70cf30066073446e923636b19114f496");
    	 book.setCn_notebook_id("70cf300660734hjdfg9fghb0887565");
    	 book.setCn_notebook_type_id("1");
    	 book.setCn_notebook_createtime(ts);
    	 book.setCn_notebook_desc("啦啦啦大家");
    	 System.out.println(book);
    	 System.out.println(dao.save(book));

     }
}
