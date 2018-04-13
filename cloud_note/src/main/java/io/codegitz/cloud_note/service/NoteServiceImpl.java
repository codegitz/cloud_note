package io.codegitz.cloud_note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.codegitz.cloud_note.dao.NoteDao;
import io.codegitz.cloud_note.entity.Note;
import io.codegitz.cloud_note.util.NoteResult;
import io.codegitz.cloud_note.util.NoteUtil;

@Service("noteService")
public class NoteServiceImpl implements NoteService{
    
	@Resource
	private NoteDao noteDao;
    
	public NoteResult<List<Map>> loadBookNotes(String bookId) {
		//返回数据集合
		List<Map> list=noteDao.findByBookId(bookId);
		
		//构建result
		NoteResult<List<Map>> result =new NoteResult<List<Map>>();
		result.setStatus(0);
		result.setMsg("加载笔记成功");
		result.setData(list);
		return result;
	}

	public NoteResult<Note> loadNote(String noteId) {
		//返回数据集合
		Note note =noteDao.findByNoteId(noteId);
		NoteResult<Note> result=new NoteResult<Note>();
		if(note==null){
			result.setStatus(1);
			result.setMsg("未找到数据");
			return result;
		}
		result.setStatus(0);
		result.setMsg("笔记信息加载成功");
		result.setData(note);
		return result;
	}

	public NoteResult<Object> updateNote(String noteId, String noteTitle, String noteBody) {
		//创建note参数
		Note note =new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_body(noteBody);
		note.setCn_note_title(noteTitle);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		//更新数据库记录
		int row=noteDao.updateNote(note);
		//构建result
		NoteResult<Object> result =new NoteResult<Object>();
		if(row==1){
			result.setStatus(0);
			result.setMsg("笔记保存成功");
			return result;
		}else{
			result.setStatus(1);
			result.setMsg("保存笔记失败");
			return result;
		}
	}

	public NoteResult<Note> addNote(String userId,String title,String bookId) {
		NoteResult<Note> result=new NoteResult<Note>();
		//创建note,并对相关属性赋值
		Note note=new Note();
		note.setCn_note_id(NoteUtil.createId());
		note.setCn_note_create_time(System.currentTimeMillis());
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		//状态 1.normal 2.delete
		note.setCn_note_status_id("1");
		note.setCn_note_title(title);
		note.setCn_user_id(userId);
		note.setCn_notebook_id(bookId);
		//类型 1.normal 2.favor3.share
		note.setCn_note_type_id(null);
		note.setCn_note_body(null);
		int i=noteDao.createNewNote(note);
		if(i==1){
			result.setStatus(0);
			result.setMsg("新建笔记成功");
			result.setData(note);
			return result;
		}else{
			result.setStatus(1);
			result.setMsg("新建笔记失败");
			return result;
		}
	}

	public NoteResult<Object> deleteNote(String noteId) {
		int i=noteDao.deleteNote(noteId);
		NoteResult<Object> result=new NoteResult<Object>();
		if(i==1){
			result.setStatus(0);
			result.setMsg("删除笔记成功");
			return result;
		}else{
			result.setStatus(1);
			result.setMsg("删除笔记出错");
			return result;
		}
	}
@Transactional	
public void deleteNotes(String... ids) {
 
	//String... 就是String[] 数组
	for (String id:ids) {
		int i=noteDao.deleteNotesById(id);
		if(i!=1){
			//抛出触发异常，事务回滚
			throw new RuntimeException("删错了");
		}
	}
}
     
}
