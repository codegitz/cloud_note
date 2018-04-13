package test.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import io.codegitz.cloud_note.dao.NoteDao;
import io.codegitz.cloud_note.entity.Note;
import io.codegitz.cloud_note.entity.Share;
import io.codegitz.cloud_note.service.ShareService;
import io.codegitz.cloud_note.util.NoteResult;
import io.codegitz.cloud_note.util.NoteUtil;
import test.TestBase;

public class TestShareService extends TestBase{

	private NoteDao noteDao;
	private ShareService shareService;
	@Before
	public void init(){
		//noteDao=this.getContext().getBean("noteDao",NoteDao.class);
		shareService=this.getContext().getBean("shareService",ShareService.class);
	}
	
	@Test
	public void test(){
		Note note=noteDao.findByNoteId("1b494f4adf354e12841416f870ae1158 ");
		Share share=new Share();
		share.setCn_note_id(note.getCn_note_id());
		share.setCn_share_body(note.getCn_note_body());
		share.setCn_share_id(NoteUtil.createId());
		share.setCn_share_title(note.getCn_note_title());
		System.out.println(share);
	    //System.out.println(shareDao.share(share));
		System.out.println(note);
	}
	
	@Test
	public void testService(){
		NoteResult<Note> result=shareService.share("1d78b8ee111e5451299f07fa6989677a7");
		System.out.println(result);
	}
	@Test
	public void testSearch(){
		NoteResult<List<Share>> result=shareService.searchNote("分享笔记的标题2",1);
		System.out.println(result);
	}
}
