package kr.co.kosmo.mvc.controller.chart;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.kosmo.mvc.controller.service.SurveyService;
import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberDTO;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;


@RestController
public class SurveyRestController {
	@Autowired
	private SurveyService surveyService;

/* 
{
"num":21,
"sub":"날씨",
"code":0,
"sdate":"2023-01-18 14:35:49",
"surveytotal":0,
"subvey":
	[
	{"subtype":"A    ","subcode":21,"surveytitle":"비가옵니다","surveycnt":500},
	{"subtype":"B    ","subcode":21,"surveytitle":"안옵니다","surveycnt":200},
	{"subtype":"C    ","subcode":21,"surveytitle":"모릅니다","surveycnt":666},
	{"subtype":"D    ","subcode":21,"surveytitle":"태풍이옵니다","surveycnt":54},
	{"subtype":"E    ","subcode":21,"surveytitle":"관심없음","surveycnt":120}
	]
}
*/
	@RequestMapping(value = "/surveyJsonObjDemo1")
	public SurveyVO surveyDetail(int num) {
		SurveyVO vo = surveyService.adminDetail(num);
		return vo;
	}
	//업그레이드
	//{"태풍이옵니다":54,"모릅니다":666,"안옵니다":200,"관심없음":120,"비가옵니다":500}
	@RequestMapping(value = "/surveyJsonObj" ,produces = "application/json;charset=utf-8")
	public Map<String, Integer> surveyDetailJson(int num) {
		SurveyVO vo = surveyService.adminDetail(num);
		//key , val => Map
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (SurveyContentVO e : vo.getSubvey()) {
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		return map;
	}	
	//업업그레이드 : title출력
	//{"태풍이옵니다":54,"모릅니다":666,"안옵니다":200,"관심없음":120,"비가옵니다":500}
	@RequestMapping(value = "/surveyJsonObj2" ,produces = "application/json;charset=utf-8")
	public String surveyDetailTitleJson(int num) {
		SurveyVO vo = surveyService.adminDetail(num);
		String subject = vo.getSub();
		//key , val => Map
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (SurveyContentVO e : vo.getSubvey()) {
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		
		//json결과를 문자열로 반환
		String result = null;
		
		//ObjectMapper 객체를 가지고 문자열로 변환을 할 수 있다
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			//{"태풍이옵니다":54,"모릅..."비가옵니다":500}
			result = mapper.writeValueAsString(map);
			//[{"sub":"내일 날씨는 어떨까요?"},map]
			result = "[{\"sub\":\""+ vo.getSub() +"\"},"+result+"]";
			System.out.println(result);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return result;
	}

}
