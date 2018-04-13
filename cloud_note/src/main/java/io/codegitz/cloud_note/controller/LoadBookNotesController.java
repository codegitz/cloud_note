package io.codegitz.cloud_note.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.codegitz.cloud_note.service.NoteService;
import io.codegitz.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class LoadBookNotesController {

	@Resource
	private NoteService noteService;
	@ResponseBody
	@RequestMapping("/loadnotes.do")
	public NoteResult<List<Map>> execute(String bookId){
		NoteResult<List<Map>> result=noteService.loadBookNotes(bookId);
		return result;
	}
	
}
