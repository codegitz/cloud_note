package io.codegitz.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.codegitz.cloud_note.service.NoteService;
import io.codegitz.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class DeleteNoteController {
       @Resource
       private NoteService noteService;
       @ResponseBody
       @RequestMapping("/delete.do")
       public NoteResult<Object> deleteNote(String noteId){
    	   NoteResult<Object> result=noteService.deleteNote(noteId);
    	   return result;
       }
}
