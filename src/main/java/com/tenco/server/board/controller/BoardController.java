package com.tenco.server.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tenco.server.board.repository.model.Board;
import com.tenco.server.board.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	@Autowired
	private final BoardService boardService;
	
//	@GetMapping("/view")
//	public String boardMainPage(Model model) {
//		List<Board> boardList = boardService.readBoardListAll();
//		model.addAttribute("boardList", boardList);
//		return "/main";
//	}
	
	@GetMapping("/view")
	public String boardMainPage(
			@RequestParam(name = "page", defaultValue = "1") Integer page
			, @RequestParam(name = "size", defaultValue = "5") Integer size
			, Model model) {
		int boardCount = boardService.readBoardCount();
		int limit = size;
		int offset = (page - 1) * size;
		
		int totalRecords = boardService.readBoardCount();
		int totalPages = (int) Math.ceil((double) totalRecords / (double) size);
		
		List<Board> boardList = boardService.readBoardListByPaging(limit, offset);
		model.addAttribute("boardList", boardList);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);
		return "/main";
	}
	

	@GetMapping("/write")
	public String boardPage() {
		return "board/write";
	}
	
	@PostMapping("/write")
	public String boardProc(HttpServletRequest request, RedirectAttributes redirectAttributes) {
	    String title = request.getParameter("title");
	    String username = request.getParameter("username");
	    String content = request.getParameter("content");
	    
	    if (title.length() > 20 || content.length() > 20) {
	        // 조건을 만족하지 않을 경우 경고 메시지를 추가하고 리다이렉트
	        redirectAttributes.addFlashAttribute("message", "제목과 내용은 20자를 넘을 수 없습니다.");
	        return "redirect:/board/write";
	    }

	    Board board = Board.builder()
	            .title(title)
	            .username(username)
	            .content(content)
	            .build();

	    boardService.createBoard(board);
	    
	    return "redirect:/board/view";
	}
	
	@GetMapping("/update")
	public String updatePage(@RequestParam(name = "id") Integer id, Model model) {
		Board board = boardService.readBoard(id);
		model.addAttribute("board", board);
		return "board/update";
	}
	
	@PostMapping("/update")
	public String updateProc(@RequestParam(name = "id") Integer id, HttpServletRequest request) {
		Board board = boardService.readBoard(id);
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		System.out.println(board.toString());
		boardService.updateBoard(board, id);
		return "redirect:/board/view";
	}
	
	@GetMapping("/delete")
	public String getMethodName(@RequestParam(name = "id") Integer id) {
		boardService.deleteBoard(id);
		return "redirect:/board/view";
	}
	
	
	@GetMapping("/detail")
	public String boardDetailPage(@RequestParam(name = "id") Integer id, Model model) {
		Board board = boardService.readBoard(id);
		model.addAttribute("board", board);
		return "board/view";
	}
	
	
	
	
}
