package io.codegitz.cloud_note.dao;

import java.util.List;

import io.codegitz.cloud_note.entity.Book;

public interface BookDao {
    public List<Book> findByUserId(String userId);
    
    public int save(Book book);
}
