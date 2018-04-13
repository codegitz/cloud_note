package test.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import io.codegitz.cloud_note.entity.Book;
import io.codegitz.cloud_note.service.BookService;
import io.codegitz.cloud_note.util.NoteResult;
import test.TestBase;

public class TestBookService extends TestBase{
        private BookService bookService;
        @Before
        public void init(){
        	bookService=super.getContext().getBean("bookService",BookService.class);
        	
        }
        @Test
        public void test(){
        	NoteResult<List<Book>> result =bookService.loadUserBooks("ecd976d53a88484eaf911049241073ad");
        	System.out.println(result.getStatus());
        	System.out.println(result.getMsg());
        	System.out.println(result.getData());
        	for(Book book:result.getData()){
        		//System.out.println(book.getCn_notebook_name());
        		System.out.println(book);
        	}
        }
}
