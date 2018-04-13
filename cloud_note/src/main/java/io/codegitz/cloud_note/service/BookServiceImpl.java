package io.codegitz.cloud_note.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import io.codegitz.cloud_note.dao.BookDao;
import io.codegitz.cloud_note.entity.Book;
import io.codegitz.cloud_note.util.NoteResult;
import io.codegitz.cloud_note.util.NoteUtil;

@Service("bookService")
public class BookServiceImpl implements BookService{
    @Resource
    private BookDao bookDao;
	public NoteResult<List<Book>> loadUserBooks(String userId) {
		List<Book> list=bookDao.findByUserId(userId);
		//System.out.println("list"+list);
		//构建返回结果result
		NoteResult<List<Book>> result=new NoteResult<List<Book>>();
		result.setStatus(0);
		result.setMsg("笔记加载完成");
		result.setData(list);
		return result;
	}
	public NoteResult<Book> addBook( String userId,String bookName) {
		NoteResult<Book> result=new NoteResult<Book>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String time = df.format(new Date());
        Timestamp ts = Timestamp.valueOf(time);
        Book book =new Book();
		book.setCn_notebook_name(bookName);
		book.setCn_notebook_type_id(NoteUtil.createId());
		book.setCn_notebook_id(NoteUtil.createId());
		book.setCn_notebook_desc(null);
		book.setCn_user_id(userId);
		book.setCn_notebook_createtime(ts);
		int i=bookDao.save(book);
		if(i==1){
			result.setStatus(0);
			result.setMsg("添加笔记成功");
			result.setData(book);
			return result;
		}else{
			result.setStatus(1);
			result.setMsg("添加笔记失败");
			return result;
		}
	}

}
