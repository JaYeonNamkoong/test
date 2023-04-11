package kr.co.kosmo.mvc.controller.chart;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberDTO;

//@Controller
//스프링 컨테이너가 Model로 선택
//현재 시스템에 있는 InternalREsourceViewResolver를 통해서 지정한 view로 forward 방식으로 이동한다

//@RestController
//CustomView 사용해서 지정한 View(JSP) 사용하지 않고 데이터 응답 가능
//주로 JSON으로 response 할 때 주로 사용함
//*****json과 같은 데이터를 서비스하기 위한 컨트롤러
@RestController
public class ChartRestController {
	@Autowired
	private MemberDaoInter memberDaoInter;

	//produces : Content-Type을 지정하는 속성
	//text/html;charset=euc-kr : 브라우저에서 html로 랜더링 할 준비
	@RequestMapping(value = "/helloView" ,produces = "text/html;charset=euc-kr")
	public String viewMessage() {
		return "안녕하세요";
	}
	
	//문법============================================
	//key에 ""있고 없고 차이!
	//Json => javascript => VO , setter => Mybatis
	//{'title':'test','price':5000} => {title:'test',price:5000} => VO , setter => Mybatis
	
	//1. Json의 Object Type -> javascript Object Type
	//application/json;charset=utf-8 : 브라우저에서 json로 랜더링 할 준비

	@RequestMapping(value = "/deptJsonView1" ,produces = "application/json;charset=utf-8")
	public MemberDTO jsonObjectDemo1(String id) {
		//test=============================
		//ajax에서 넘어오는 deptno값
		/*
		System.out.println("id => "+id);
		
		MemberDTO vo = new MemberDTO();
		vo.setName("김길동");
		vo.setNum(90);
		vo.setAge(11);
		vo.setGender("남");
		vo.setId("bigdaddy");
		vo.setPwd("11");
		vo.setMdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		return vo;
		*/
		//=================================
		
		try {
			MemberDTO vo = memberDaoInter.jsonDemo(id);
			return vo;			
		} catch (Exception e) {
			MemberDTO vo = new MemberDTO();
			vo.setName("없음");
			return vo;			
		}
	}
	
	@RequestMapping(value = "/memberlistView" ,produces = "application/json;charset=utf-8")
	public List<MemberDTO> jsonmemberlist() {
		List<MemberDTO> list = memberDaoInter.memberList();
		return list;			
	}

}
