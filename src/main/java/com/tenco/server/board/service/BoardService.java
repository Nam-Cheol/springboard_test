package com.tenco.server.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.server.board.repository.interfaces.BoardRepository;
import com.tenco.server.board.repository.model.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	@Autowired
	private final BoardRepository boardRepository;
	
	@Transactional
	public Integer createBoard(Board board) {
		int rowCount = 0;
		rowCount = boardRepository.insert(board);
		return rowCount;
	}
	
	public void updateBoard(Board board, Integer id) {
		boardRepository.updateById(board, id);
	}
	
	@Transactional
	public void deleteBoard(Integer id) {
		boardRepository.deleteById(id);
	}
	
	public List<Board> readBoardListAll() {
		List<Board>	boardList = boardRepository.findAll();
		return boardList;
	}
	
	public List<Board> readBoardListByPaging(Integer limit, Integer offset) {
		List<Board>	boardList = boardRepository.findByPaging(limit, offset);
		return boardList;
	}
	
	public Board readBoard(Integer id) {
		return boardRepository.findById(id);
	}
	
	public Integer readBoardCount() {
		return boardRepository.boardCount();
	}
	
}
