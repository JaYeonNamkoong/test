package kr.co.kosmo.mvc.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.kosmo.mvc.vo.DeptVO;
import kr.co.kosmo.mvc.vo.SawonVO;

public interface SawonDaoInter {
	//deptlist
	//DeptVO만 받아도 안에 List 있으므로 mapper의 값들 받을 수 O
	public DeptVO getDeptList(int num);	
	
	//sawonPhone
	//SawonVO만 받아도 sawon_phone 받을 수 O
	public List<SawonVO> getSawonPhoneList();
	
	//프로시저
	public List<HashMap>procedureList(int num);
    public void procedureAdd(SawonVO vo);
}
