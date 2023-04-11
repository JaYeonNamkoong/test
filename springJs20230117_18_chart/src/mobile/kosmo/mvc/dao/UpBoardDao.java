package mobile.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.PageSearchDTO;
import kr.co.kosmo.mvc.vo.UpBoardDTO;

@Repository
public class UpBoardDao implements UpBoardDaoInter{
	@Autowired
	private SqlSessionTemplate ss;
	
	@Override
	public void addUpBoard(UpBoardDTO vo) {
		ss.insert("upboard.add", vo);	
	}
	@Override
	public int getCnt() {
		return ss.selectOne("upboard.totalCountBack");
	}

	@Override
	public List<UpBoardDTO> getList(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return ss.selectList("upboard.listpageBack",map);
	}

	@Override
	public UpBoardDTO getDetail(int num) {
		// TODO Auto-generated method stub
		return ss.selectOne("upboard.detail", num);
	}

	@Override
	public void upUpBoard(UpBoardDTO vo) {
		// ss.update("upboard.update", vo);
	}

	@Override
	public void upDelete(int num) {
		// ss.delete("upboard.del", num);
	}
	//Page & Search Dao
	@Override
	public int getCnt(PageSearchDTO vo) {
		return ss.selectOne("upboard.totalCount",vo);
	}
	@Override
	public List<UpBoardDTO> getList(PageSearchDTO vo) {
		return ss.selectList("upboard.listpage",vo);
	}
}
