package kr.co.kosmo.mvc.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.kosmo.mvc.dao.MyBoardDaoInter;
import kr.co.kosmo.mvc.vo.BoardVO;

@Controller
@RequestMapping(value = "/myboard")
public class MyBoardController {

	@Autowired
	private MyBoardDaoInter myBoardDaoInter;
	
	@RequestMapping(value="/boardlist")
	public String myBoardList(Model m) {
		
		List<BoardVO> list = myBoardDaoInter.listBoard();
		m.addAttribute("list", list);
		return "board/boardList";
		
	}
	@GetMapping(value="/boardForm")
	public String myBoardForm() {
		
		return "board/boardForm";
	}
	@PostMapping(value="/boardIn")
	public String myBoardAdd(BoardVO vo) {
		myBoardDaoInter.addBoard(vo);
		return "redirect:boardlist";
	}
	
	@GetMapping(value="/boardDetail")
	public String myBoardDetail(Model m,int num) {
		BoardVO vo = myBoardDaoInter.detailBoard(num);
		m.addAttribute("vo", vo);
		return "board/boardDetail";
	}
}
