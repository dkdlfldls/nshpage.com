package com.nshpage.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.nshpage.vo.Board;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.nshpage.mapper.BoardMapper";
	
	@Override
	public List<Board> getAllBoard(int category_id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".getAllBoard", category_id);
	}

	@Override
	public Board read(Board board) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".read", board);
	}

	@Override
	public void write(Board board) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(board.getWriter());
		System.out.println(board.getUser_id());
		System.out.println(board.getTitle());
		session.insert(namespace + ".write", board);
	}

	@Override
	public void update(Board board) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".update", board);
		
	}

	@Override
	public void delete(Board board) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete", board);
		
	}

}
