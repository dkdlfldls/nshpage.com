package com.nshpage.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nshpage.service.BoardServiceImpl;
import com.nshpage.vo.Board;

@Controller
public class BaseBoardController {
	
private static final Logger logger = LoggerFactory.getLogger(BaseBoardController.class);
	
	@Inject
	BoardServiceImpl boardService;

	@RequestMapping(value = "/board/get_list", method = RequestMethod.GET)
	public String getList(Model model, @RequestParam("category_id") int category_id) throws Exception {
		logger.info("BasicBoardIndex request/ category_id : " + category_id);
		
		model.addAttribute("category_id", category_id);
		
		return "basic_board/basicBoardIndex";
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String write() throws Exception {
		logger.info("BasicBoard Write page request");
		
		return "basic_board/basicBoardWrite";
	}
	
	
}
