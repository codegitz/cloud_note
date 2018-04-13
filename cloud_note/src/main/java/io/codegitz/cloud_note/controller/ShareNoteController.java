package io.codegitz.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.codegitz.cloud_note.entity.Note;
import io.codegitz.cloud_note.service.ShareService;
import io.codegitz.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/share")
public class ShareNoteController {

	@Resource
	private ShareService shareService;
	
	@ResponseBody
	@RequestMapping("/add.do")
	public NoteResult<Note> execute(String noteId){
		NoteResult<Note> result=new NoteResult<Note>();
		result=shareService.share(noteId);
		return result;	
	}
}
