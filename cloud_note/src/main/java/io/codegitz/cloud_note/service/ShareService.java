package io.codegitz.cloud_note.service;

import java.util.List;

import io.codegitz.cloud_note.entity.Note;
import io.codegitz.cloud_note.entity.Share;
import io.codegitz.cloud_note.util.NoteResult;

public interface ShareService {

	//分享笔记
	public NoteResult<Note> share(String noteId);
	
	//搜索分享笔记
	public NoteResult<List<Share>> searchNote(String keyword,int page);
 }
