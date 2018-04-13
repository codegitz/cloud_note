package test.service;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import io.codegitz.cloud_note.entity.Note;
import io.codegitz.cloud_note.service.NoteService;
import io.codegitz.cloud_note.util.NoteResult;
import test.TestBase;

public class TestNoteService extends TestBase{
       private NoteService noteService;
       @Before
       public void init(){
    	   noteService=super.getContext().getBean("noteService",NoteService.class);
    	   
       }
       @Test 
       public void test(){
    	   NoteResult<List<Map>> result=noteService.loadBookNotes("ecd976d53a88484eaf911049241073ad");
    	   System.out.println(result.getStatus());                 
    	   System.out.println(result.getMsg());
    	   System.out.println(result);
       }
       @Test 
       public void test1(){
    	   NoteResult<Note> result=noteService.loadNote("ecd976d53a88484eaf911049241073ad");
    	   System.out.println(result.getStatus());                 
    	   System.out.println(result.getMsg());
    	   System.out.println(result);
       }
       @Test 
       public void testupdate(){
    	   String noteId="ecd976d53a88484eaf911049241073ad";
    	   String noteTitle="更新后的标题2";
    	   String noteBody="更新后的笔记2";
    	   NoteResult<Object> result=noteService.updateNote(noteId, noteTitle, noteBody);
    	   System.out.println(result.getStatus());                 
    	   System.out.println(result.getMsg());
    	   System.out.println(result);
       }
       @Test
       public void testDelete(){
    	   NoteResult<Object> result=noteService.deleteNote("7318671641684437862fbc9fa74e18da ");
    	   System.out.println(result);
       }
       @Test
       public void testDeleteNotes(){
    	   noteService.deleteNotes("id1","id2","id3");
       }
}
