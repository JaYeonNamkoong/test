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
//������ �����̳ʰ� Model�� ����
//���� �ý��ۿ� �ִ� InternalREsourceViewResolver�� ���ؼ� ������ view�� forward ������� �̵��Ѵ�

//@RestController
//CustomView ����ؼ� ������ View(JSP) ������� �ʰ� ������ ���� ����
//�ַ� JSON���� response �� �� �ַ� �����
//*****json�� ���� �����͸� �����ϱ� ���� ��Ʈ�ѷ�
@RestController
public class ChartRestController {
	@Autowired
	private MemberDaoInter memberDaoInter;

	//produces : Content-Type�� �����ϴ� �Ӽ�
	//text/html;charset=euc-kr : ���������� html�� ������ �� �غ�
	@RequestMapping(value = "/helloView" ,produces = "text/html;charset=euc-kr")
	public String viewMessage() {
		return "�ȳ��ϼ���";
	}
	
	//����============================================
	//key�� ""�ְ� ���� ����!
	//Json => javascript => VO , setter => Mybatis
	//{'title':'test','price':5000} => {title:'test',price:5000} => VO , setter => Mybatis
	
	//1. Json�� Object Type -> javascript Object Type
	//application/json;charset=utf-8 : ���������� json�� ������ �� �غ�

	@RequestMapping(value = "/deptJsonView1" ,produces = "application/json;charset=utf-8")
	public MemberDTO jsonObjectDemo1(String id) {
		//test=============================
		//ajax���� �Ѿ���� deptno��
		/*
		System.out.println("id => "+id);
		
		MemberDTO vo = new MemberDTO();
		vo.setName("��浿");
		vo.setNum(90);
		vo.setAge(11);
		vo.setGender("��");
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
			vo.setName("����");
			return vo;			
		}
	}
	
	@RequestMapping(value = "/memberlistView" ,produces = "application/json;charset=utf-8")
	public List<MemberDTO> jsonmemberlist() {
		List<MemberDTO> list = memberDaoInter.memberList();
		return list;			
	}

}
