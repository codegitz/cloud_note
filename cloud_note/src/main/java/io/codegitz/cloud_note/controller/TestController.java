package io.codegitz.cloud_note.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.codegitz.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/test")
public class TestController {

	@ResponseBody
	@RequestMapping("/ajax.do")
	public NoteResult<Object> execute(){
		NoteResult<Object> result=new NoteResult<Object>();
		result.setMsg("这是返回跨域的文本信息");
		return result;
	}
}
