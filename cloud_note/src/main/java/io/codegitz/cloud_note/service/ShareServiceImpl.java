package io.codegitz.cloud_note.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.codegitz.cloud_note.dao.NoteDao;
import io.codegitz.cloud_note.dao.ShareDao;
import io.codegitz.cloud_note.entity.Note;
import io.codegitz.cloud_note.entity.Share;
import io.codegitz.cloud_note.util.NoteResult;
import io.codegitz.cloud_note.util.NoteUtil;

@Service("shareService")
@Transactional
public class ShareServiceImpl implements ShareService{

	@Resource
	private NoteDao noteDao;
	@Resource
	private ShareDao shareDao;
	public NoteResult<Note> share(String noteId) {
		Note note=noteDao.findByNoteId(noteId);
		Share share=new Share();
		share.setCn_note_id(note.getCn_note_id());
		share.setCn_share_body(note.getCn_note_body());
		share.setCn_share_id(NoteUtil.createId());
		share.setCn_share_title(note.getCn_note_title());
		NoteResult<Note> result=new NoteResult<Note>();
		System.out.println(share);
		int i=shareDao.share(share);
		//模拟异常
		/*String str=null;
		str.length();*/
		//int i=0;
		if(i==1){
			result.setStatus(0);
			result.setMsg("笔记分享成功");
			result.setData(note);
			return result;
		}else{
			result.setStatus(1);
			result.setMsg("笔记分享失败");
			return result;
		}
	}
	public NoteResult<List<Share>> searchNote(String keyword,int page) {
		String title="%"+keyword+"%";
		int begin=(page-1)*3;//计算抓起记录起点
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("keyword",keyword);
		params.put("begin", begin);
		List<Share> list=shareDao.search(params);
		NoteResult<List<Share>> result=new NoteResult<List<Share>>();
		result.setStatus(0);
		result.setMsg("搜索完成");
		result.setData(list);
		return result;
	}
 
}
