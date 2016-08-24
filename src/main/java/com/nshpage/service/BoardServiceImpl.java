package com.nshpage.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nshpage.repository.BoardDAO;
import com.nshpage.vo.Board;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Override
	public List<Board> getAllBoard(int category_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllBoard(category_id);
	}

	@Override
	public void write(Board board) throws Exception {
		// TODO Auto-generated method stub
		dao.write(board);
	}

}
