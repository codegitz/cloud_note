package io.codegitz.cloud_note.service;

import java.util.List;

import io.codegitz.cloud_note.entity.Book;
import io.codegitz.cloud_note.entity.Note;
import io.codegitz.cloud_note.util.NoteResult;

public interface BookService {
       public NoteResult<List<Book>> loadUserBooks(String userId);
       
       //增加笔记
       public NoteResult<Book> addBook( String userId,String bookName);
       
}
