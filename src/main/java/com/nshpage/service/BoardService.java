package com.nshpage.service;

import java.util.List;

import com.nshpage.vo.Board;

public interface BoardService {
	public List<Board> getAllBoard(int category_id) throws Exception;
	
	public void write(Board board) throws Exception;
}
