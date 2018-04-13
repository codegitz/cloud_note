package io.codegitz.cloud_note.service;

import java.util.List;
import java.util.Map;

import io.codegitz.cloud_note.entity.Note;
import io.codegitz.cloud_note.util.NoteResult;

public interface NoteService {
       public NoteResult<List<Map>> loadBookNotes(String bookId);
       //显示笔记信息
       public NoteResult<Note> loadNote(String bookId);
       //保存更新笔记
       public NoteResult<Object> updateNote(String noteId,String noteTitle,String noteBody);
       
       //新建笔记
       public NoteResult<Note> addNote(String userId,String title,String bookId);
       
       //删除笔记
       public NoteResult<Object> deleteNote(String noteId); 
       
       public void deleteNotes(String... ids);

}
