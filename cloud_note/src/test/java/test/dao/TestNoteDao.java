package test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import io.codegitz.cloud_note.dao.NoteDao;
import io.codegitz.cloud_note.entity.Note;
import io.codegitz.cloud_note.util.NoteUtil;
import test.TestBase;

public class TestNoteDao extends TestBase {
	private NoteDao noteDao;

	@Before
	public void init() {
		noteDao = super.getContext().getBean("noteDao", NoteDao.class);

	}

	@Test
	public void test() {
		List<Map> list = noteDao.findByBookId("ecd976d53a88484eaf911049241073ad");
		System.out.println("走了没");
		System.out.println(list);
		for (Map note : list) {
			System.out.println("查询成功");
			System.out.println("hello" + note.get("cn_note_id") + "," + note.get("cn_note_title"));

		}
	}

	@Test
	public void test1() {
		Note note = noteDao.findByNoteId("001361530e464fd1a90cd0c9c765cb5b");
		System.out.println("走了没");
		System.out.println(note);

		System.out.println("查询成功");
		System.out.println(note.getCn_note_status_id());

	}

	@Test
	public void testupdate() {
		Note note = new Note();
		note.setCn_note_body("这是更新后的文本");
		note.setCn_note_title("这是更新后的标题");
		note.setCn_note_id("ecd976d53a88484eaf911049241073ad");
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		System.out.println(note);
		int i=noteDao.updateNote(note);
        System.out.println(i);
	}
	@Test
	public void testCreateNote(){
		Note note=new Note();
		note.setCn_note_body(null);
		note.setCn_note_title("这是新建的标题");
		note.setCn_note_id(NoteUtil.createId());
		note.setCn_notebook_id("ecd976d53a88484eaf911049241073ad");
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		note.setCn_note_create_time(System.currentTimeMillis());
		note.setCn_user_id("ecd976d53a88484eaf911049241073ad");
		note.setCn_note_status_id("1");
		note.setCn_note_type_id(null);
		System.out.println(note);
     	System.out.println(noteDao.createNewNote(note));
	}
	@Test
	public void testDeleteNote(){
		int i=noteDao.deleteNote("001361530e464fd1a90cd0c9c765cb5b");
		System.out.println(i);
	}
	
	@Test
	public void testUpdateNoteByMap(){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("title", "java");
		map.put("body", "helloworld");
		map.put("noteId", "ecd976d53a88484eaf911049241073ad");
		System.out.println(noteDao.updateNoteByMap(map));
	}
	@Test
	public void testDeleteNotes(){
	 
		Map<String,Object> map=new HashMap<String, Object>();
		String[] ids={"id1","id2","id3"};
		map.put("ids",ids);
		map.put("status", 2);
		System.out.println(noteDao.deleteNotes(map));
		
	}
}
