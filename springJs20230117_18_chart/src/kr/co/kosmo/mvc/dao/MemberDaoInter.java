package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.MemberDTO;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;

public interface MemberDaoInter {
	public void addMember(MemberDTO dto);
	public int idcheck(String id);
	
	//Login : ID PWD vo�� �����ϰ� ��ȯ������ id,name���� ��ȯ
	public MemberDTO login(MemberDTO vo);	
	//AOP���� Login�α�ó���� ���� �޼���
	public void addLoginLogging(MyLoginLoggerDTO vo);	
	
	//json
	public MemberDTO jsonDemo(String id);	
	
	//json :memberlist
	public List<MemberDTO> memberList();	
}
