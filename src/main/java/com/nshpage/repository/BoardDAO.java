package com.nshpage.repository;

import java.util.List;

import com.nshpage.vo.Board;

public interface BoardDAO {
	public List<Board> getAllBoard(int category_id) throws Exception;
	
	public Board read(Board board) throws Exception;
	
	public void write(Board board) throws Exception;
	
	public void update(Board board) throws Exception;
	
	public void delete(Board board) throws Exception;
}
