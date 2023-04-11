package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.MemberDTO;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;

public interface MemberDaoInter {
	public void addMember(MemberDTO dto);
	public int idcheck(String id);
	
	//Login : ID PWD vo로 전송하고 반환값으로 id,name등을 반환
	public MemberDTO login(MemberDTO vo);	
	//AOP에서 Login로깅처리를 위한 메서드
	public void addLoginLogging(MyLoginLoggerDTO vo);	
	
	//json
	public MemberDTO jsonDemo(String id);	
	
	//json :memberlist
	public List<MemberDTO> memberList();	
}
