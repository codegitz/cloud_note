package io.codegitz.cloud_note.dao;

import java.util.List;
import java.util.Map;

import io.codegitz.cloud_note.entity.Note;

public interface NoteDao {
      public List<Map> findByBookId(String bookId);
      
      //加载笔记内容
      public Note findByNoteId(String NoteId);
      
      //保存笔记
      public int updateNote(Note note);
      
      public int updateNoteByMap(Map<String,Object> map);
      
      //新建笔记
      public int createNewNote(Note note);
      
      //删除笔记
      public int deleteNote(String noteId);
      /*
       * map中需要添加两个参数
       * map={ids:[id1,id2,id3...],status:2}
       * ids:代表被删掉的笔记的id列表
       * status：代表被删除的笔记的状态属性
       */
      public int deleteNotes(Map<String,Object> map);
      
      public int deleteNotesById(String id);
      
      
}
