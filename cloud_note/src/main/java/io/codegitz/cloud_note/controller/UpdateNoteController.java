package io.codegitz.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.codegitz.cloud_note.service.NoteService;
import io.codegitz.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class UpdateNoteController {
     @Resource
     private NoteService noteService;
     @ResponseBody
     @RequestMapping("/update.do")
     public NoteResult<Object> execute(String noteId,String noteTitle,String noteBody){
    	 NoteResult<Object> result=noteService.updateNote(noteId, noteTitle, noteBody);
    	 return result;
     }
}
