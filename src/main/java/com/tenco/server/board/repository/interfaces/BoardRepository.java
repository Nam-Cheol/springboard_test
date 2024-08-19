package com.tenco.server.board.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.server.board.repository.model.Board;

@Mapper
public interface BoardRepository {

	public int insert(Board account);
	public int updateById(@Param("board") Board board,@Param("id") Integer id);
	public int deleteById(Integer id);
	
	public List<Board> findAll();
	public List<Board> findByPaging(@Param("limit") int limit
			, @Param("offset") int offset);
	public int boardCount();
	public Board findById(@Param("id") Integer id);
	
}
