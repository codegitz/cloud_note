package io.codegitz.cloud_note.dao;

import java.util.List;
import java.util.Map;

import io.codegitz.cloud_note.entity.Share;

public interface ShareDao {

	
	//分享笔记
	public int share(Share share);
	
	 //搜索分享笔记
    public List<Share> search(Map params);
}
