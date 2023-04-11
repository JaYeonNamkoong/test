package kr.co.kosmo.mvc.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberDTO;

@Controller
@RequestMapping(value = "/login")
public class LoginCheckController {
	@Autowired
	private MemberDaoInter memberList;
	
	@RequestMapping(value = "/loginForm")
	public String loginForm() {
		return "login/loginForm";
	}

	//폼에서 전송되어 온 파라미터의 값을 기준으로 
	//	=> 데이터베이스에서 인증된 회원이면 세션의 값을 저장
	//	=> 아니면 오류메세지를 보여주기
	//String userAgent : 사용자 디바이스/Aspect에서 받을 데이터 => @RequestHeader("User-Agent")
	//HttpServletRequest : ip받기위해
	@PostMapping(value = "/loginInfo")
	public ModelAndView loginfProcess(HttpSession session, HttpServletRequest request,
			MemberDTO vo,
			@RequestHeader("User-Agent") String userAgent) {
		ModelAndView mav = new ModelAndView("redirect:/web/main");
/*
		//test
		String dbid="xman";
		String dbpwd="1234";
		if(dbid.equalsIgnoreCase(vo.getId()) && dbpwd.equals(vo.getPwd())) { //login success
			vo.setName("김길동");
			session.setAttribute("sessionName", vo.getName());
			session.setAttribute("sessionID", vo.getId());
		}else {
			mav.setViewName("error/paramException");
			mav.addObject("emsg", "로그인 실패입니다.");
		}
*/		
		MemberDTO dto = memberList.login(vo);
		if(dto == null) { //login success
			mav.setViewName("error/paramException");
			mav.addObject("emsg", "로그인 실패입니다.");
		}else {
			session.setAttribute("sessionName", dto.getName());
			session.setAttribute("sessionID", dto.getId());
			System.out.println("로그인 실행! 및 세션 저장 => Proceeding Call");
		}
		
		return mav;
	}

	@GetMapping(value = "/logout")
	public ModelAndView loginfoutProcess(HttpSession session,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
			session.removeAttribute("sessionName");
			session.removeAttribute("sessionID");
			mav.setViewName("redirect:/web/main");
			System.out.println("로그아웃 실행! 및 세션 삭제 => Proceeding Call");
		return mav;
	}
}
