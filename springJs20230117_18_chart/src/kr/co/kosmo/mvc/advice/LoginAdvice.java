package kr.co.kosmo.mvc.advice;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;

@Component
@Aspect
public class LoginAdvice {
	private String userAgent;

	@Autowired
	private MemberDaoInter memberList;

	@Around("execution(* kr.co.kosmo.mvc.controller.login.LoginCheckController.loginf*(..))")
	public ModelAndView loginLogger(ProceedingJoinPoint jp) {
		System.out.println("loginLogger 동작!");
		ModelAndView rpath = null;

		//step1) 메서드의 이름을 가져와서 로그인과 로그아웃 구별
		String methodName = jp.getSignature().getName();
		System.out.println("methodName : " + methodName);
		
		//step2) JoinPoint로부터 타겟 객체의 메서드 인자값 받아오기
		Object[] fd = jp.getArgs();
		for (Object e : fd) {
			System.out.println(e.getClass().getName());
		}
		if(methodName.equals("loginfProcess")) { //로그인
			//전처리 영역
			try {
				rpath = (ModelAndView) jp.proceed(); //로그인 메서드 호출
			} catch (Throwable e) {

				e.printStackTrace();
			}
			//=====================================================================
			//받아와야할 값 : 세션id,request reip,DTO,userAgent => loginfProcess메서드의 인자값 => 4개
			//HttpSession session, HttpServletRequest request 배열이라 메서드마다 인자값 순서 동일해야함!
			//=====================================================================
			//1번째 인자값 : session => 세션에 들어있는 id 구하기
			HttpSession session = (HttpSession) fd[0];
			String uid = (String) session.getAttribute("sessionID");
			System.out.println("uid => "+uid);//ip 출력
			//2번째 인자값 : request => ip 구하기
			String reip = ((HttpServletRequest) (fd[1])).getRemoteAddr(); //ip 출력 => 해당 배열위치 [0,1
			System.out.println("reip => "+reip);//ip 출력
			//4번째 인자값 : userAgent => 사용자 디바이스 구하기
			userAgent = (String) fd[3]; //메서드에서 4번째 인자값 => 배열위치[0,1,2,3]
			System.out.println("agent => "+userAgent);//사용자디바이스 출력
			//=====================================================================
			//로그인 정보 DB에 저장
			MyLoginLoggerDTO vo = new MyLoginLoggerDTO();
			vo.setIdn(uid);
			vo.setStatus("login");
			vo.setReip(reip);
			vo.setUagent(userAgent);
			memberList.addLoginLogging(vo);
		}else if(methodName.equals("loginfoutProcess")) { //로그아웃
			//받아와야할 값 : 세션,request => 2개
			//=====================================================================
			//1번째 인자값 : session => 세션에 들어있는 id 구하기
			HttpSession session = (HttpSession) fd[0];
			String uid = (String) session.getAttribute("sessionID");
			//2번째 인자값 : request => ip 구하기
			String reip = ((HttpServletRequest) (fd[1])).getRemoteAddr(); //ip 출력 => 해당 배열위치 [0,1
			//=====================================================================
			//로그아웃 정보 DB에 저장
            MyLoginLoggerDTO vo = new MyLoginLoggerDTO();
            vo.setIdn(uid);
            vo.setStatus("logout");//로그아웃
            vo.setReip(reip);
            vo.setUagent(userAgent);
            memberList.addLoginLogging(vo);
            //=====================================================================
			//후처리 영역
			try {
				rpath = (ModelAndView) jp.proceed(); //로그아웃 메서드 호출
			} catch (Throwable e) {

				e.printStackTrace();
			}
		}
		System.out.println("동작2");

		return rpath;
	}
}
