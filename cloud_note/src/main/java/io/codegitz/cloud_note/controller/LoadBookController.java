package io.codegitz.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.codegitz.cloud_note.entity.Book;
import io.codegitz.cloud_note.service.BookService;
import io.codegitz.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/book")
public class LoadBookController {
    @Resource   
	private BookService bookService;
    @ResponseBody
    @RequestMapping("/loadBooks.do")
    public NoteResult<List<Book>> execute(String userId){
    	NoteResult<List<Book>> result= bookService.loadUserBooks(userId);
    	return result;
    }
}
