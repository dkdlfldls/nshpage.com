package com.nshpage.ajax_controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.nshpage.models.IpGather;
import com.nshpage.service.BoardServiceImpl;
import com.nshpage.service.UserServiceImpl;
import com.nshpage.vo.Board;

@RestController
public class AjaxBoardController {
	private static final Logger logger = LoggerFactory.getLogger(AjaxBoardController.class);

	@Inject
	private BoardServiceImpl boardService;
	
	@Inject
	private UserServiceImpl userService;
	
	@Autowired
	private IpGather ipGather;
	
	@RequestMapping(value="/ajax/board/getAllList", method=RequestMethod.POST)
	public List<Board> getAllBoard(@RequestParam("category_id") int category_id) throws Exception {
		logger.info("getAllList request");
		return boardService.getAllBoard(category_id);
	}
	
	@RequestMapping(value="/ajax/board/write", method=RequestMethod.POST)
	public String write(Board board, 
					  HttpSession session,
					  @RequestParam("board") String boardType) throws Exception {
		logger.info("board write req");
		board.setIp(ipGather.ip(((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest()));
		board.setUser_id((int)session.getAttribute("user_id"));
		board.setWriter((String)session.getAttribute("name"));
		board.setCategory_id(1);
		if (boardType.equals("basic")) {
			//user_id, writer, category_id, title, content, ip
			//user_id : session o
			//writer : param o
			//category_id : param 우선 1 나중에 param으로 받아야함
			//title, content : param o
			//ip : code  o
			boardService.write(board);
		}
		
		return "ok";
	}
}
