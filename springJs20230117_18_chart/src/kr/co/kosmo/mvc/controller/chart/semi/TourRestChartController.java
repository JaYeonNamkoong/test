package kr.co.kosmo.mvc.controller.chart.semi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.kosmo.mvc.controller.service.SurveyService;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@RestController
public class TourRestChartController {
	@Autowired
	private SurveyService surveyService;
	
	//[{타이틀},Map(값들{},{}...)]
	//{} : key:value
	//[{sub:연령대별~},Map]
	//Map : {20대:500},{30대:500},{40대:500},{50대:500}...
	@RequestMapping(value = "/tourChartJson" , produces = "application/json;charset=utf-8")
	public String busan(int num) {
		//1. 핸들링할 데이터 VO에 저장
		SurveyVO vo = surveyService.adminDetail(num);
		
		//2. survey 주제 저장 => String
		//{sub:연령대별~}
		String subject = vo.getSub();
		
		//3. survey 데이터 저장 => Map
		Map<String, Integer> map = new HashMap<String, Integer>();
		//3-1. foreach문으로 survey 데이터 map 안에 저장
		//{20대:500},{30대:500}...
		//SurveyVO안에 List 선언되었으므로 SurveyContentVO에 값 저장 => vo.getSubvey()
		for (SurveyContentVO e : vo.getSubvey()) {
			//key : e.getSurveytitle()
			//value : e.getSurveycnt()
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		
		//4. return반환 해줄 결과값 선언 => String
		String result = null;
		
		//5. ObjectMapper 선언 : 객체를 문자열로 변환 => JSON?
		ObjectMapper mapper = new ObjectMapper();

		//6. result에 문자열로 변환한 값(=Map_survey 데이터) 저장 => try/catch
		try {
			//{"30대":100,"20대":550,"50대":300,"40대":150,"60대":350}
			result = mapper.writeValueAsString(map);
			
		//7. result에 JSON이 받을 수 있는 형태로 변경 후 저장(핸들링)
			//형식 : [{"sub":"주제"},map]
			result = "[{\"sub\":\""+ vo.getSub() +"\"},"+result+"]";
			System.out.println(result); //test
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		return result;
	}

}
