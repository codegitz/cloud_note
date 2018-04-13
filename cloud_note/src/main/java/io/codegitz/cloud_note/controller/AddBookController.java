package io.codegitz.cloud_note.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.codegitz.cloud_note.entity.Book;
import io.codegitz.cloud_note.service.BookService;
import io.codegitz.cloud_note.util.NoteResult;
import io.codegitz.cloud_note.util.NoteUtil;

@Controller
@RequestMapping("/book")
public class AddBookController {
      
	@Resource
	private BookService bookService;
	//private Book book;
	private NoteUtil util;
	@ResponseBody
	@RequestMapping("/add.do")
	public NoteResult<Book> execute( String userId,String bookName){
		NoteResult<Book> result=bookService.addBook(userId,bookName);
		return result;
	}
}
