package io.codegitz.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.codegitz.cloud_note.entity.Note;
import io.codegitz.cloud_note.service.NoteService;
import io.codegitz.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class AddNoteController {

	@Resource
	private NoteService noteService;
	@ResponseBody
	@RequestMapping("/add.do")
	public NoteResult<Note> execute(String userId,String title,String bookId){
		NoteResult<Note> result= noteService.addNote(userId, title, bookId);
		return result;
	}
}
