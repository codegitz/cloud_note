package test.dao;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import io.codegitz.cloud_note.dao.RelationDao;
import io.codegitz.cloud_note.entity.Book;
import io.codegitz.cloud_note.entity.User;
import test.TestBase;

public class TestRelationDao extends TestBase{
     private RelationDao rDao;
     
     @Before
     public void init(){
    	 rDao=this.getContext().getBean("relationDao", RelationDao.class);
     }
     
     @Test
     public void testMany(){
    	 User user=rDao.findUserAndBook("ecd976d53a88484eaf911049241073ad");
    	 System.out.println("========用户信息======");
    	 System.out.println("名字："+user.getCn_user_name());
    	 System.out.println("昵称："+user.getCn_user_nick());
    	 System.out.println("笔记本数量："+user.getBooks().size());
    	 System.out.println("======笔记本列表=========");
    	 for(Book book:user.getBooks()) {
			System.out.println(book.getCn_notebook_name());
		}
     }
     
     @Test
     public void testOne(){
    	 List<Book> lists=rDao.findBookAndUser();
    	 for(Book book: lists){
    		 if(book.getUser()!=null){
    			 System.out.println(book.getCn_notebook_name()+","+book.getCn_notebook_createtime());
    			 System.out.println(book.getUser().getCn_user_name());
    		 }
    	 }
     }
}
