package io.codegitz.cloud_note.dao;

import java.util.List;

import io.codegitz.cloud_note.entity.Book;
import io.codegitz.cloud_note.entity.User;

public interface RelationDao {

	//关联多个对象
	public User findUserAndBook(String userId);
	public User findUserAndBook1(String userId);
	
	//关联单个对象
	public List<Book> findBookAndUser();	
	public List<Book> findBookAndUser1();
}
