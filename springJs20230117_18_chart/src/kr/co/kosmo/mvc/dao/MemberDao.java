package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.MemberDTO;
import kr.co.kosmo.mvc.vo.MyLoginLoggerDTO;
//Dao단은 @Repository 사용 => Dao를 빈으로 등록 시켜준다.
//싱글톤이다. 기본이
@Repository
public class MemberDao implements MemberDaoInter{
	// kosmo-web.xml에서 정의한 bean byName
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public void addMember(MemberDTO dto) {
		// SqlSession ss = FactoryService.getFactory().openSession(true); 대신 
		// 해주는 설정이 <bean id="ss" class="org.mybatis.spring.SqlSessionTemplate">
		ss.insert("member.add", dto);
	
	}
	@Override
	public int idcheck(String id) {
		return ss.selectOne("member.idchk", id);
	}

	@Override
	public MemberDTO login(MemberDTO vo) {
		return ss.selectOne("member.login", vo);
	}
	@Override
	public void addLoginLogging(MyLoginLoggerDTO vo) {
		ss.selectOne("member.logger_in", vo);
	}
	
	@Override
	public MemberDTO jsonDemo(String id) {
		return ss.selectOne("member.jsonDemo", id);
	}

	@Override
	public List<MemberDTO> memberList() {
		return ss.selectList("member.memberlist");
	}

}
