package test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import io.codegitz.cloud_note.dao.ShareDao;
import io.codegitz.cloud_note.entity.Share;
import io.codegitz.cloud_note.util.NoteUtil;
import test.TestBase;

public class TestShareDao extends TestBase{
     
	private ShareDao shareDao;
	
	@Before
	public void init(){
		shareDao=this.getContext().getBean("shareDao",ShareDao.class);
	}
	
	@Test
	public void test(){
		Share share=new Share();
		share.setCn_note_id(NoteUtil.createId());
		share.setCn_share_body(null);
		share.setCn_share_id(NoteUtil.createId());
		share.setCn_share_title("分享笔记的标题2");
		int i=shareDao.share(share);
		System.out.println(i);
	}
	@Test
	public void testSearch(){
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("keyword", "分享笔记的标题2");
		params.put("begin", 1);
		List<Share> lists=shareDao.search(params);
		System.out.println(lists.size());
		System.out.println(lists);
	}
}
