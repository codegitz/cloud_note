package io.codegitz.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.codegitz.cloud_note.entity.Share;
import io.codegitz.cloud_note.service.ShareService;
import io.codegitz.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/share")
public class ShareSearchController {

	@Resource
	private ShareService shareService;
	@ResponseBody
	@RequestMapping("/search.do")	
	public NoteResult<List<Share>> searchShareNote(String keyword,int page){
		NoteResult<List<Share>> result=shareService.searchNote(keyword,page);
		return result; 
	}
}
