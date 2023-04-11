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
	
	//[{Ÿ��Ʋ},Map(����{},{}...)]
	//{} : key:value
	//[{sub:���ɴ뺰~},Map]
	//Map : {20��:500},{30��:500},{40��:500},{50��:500}...
	@RequestMapping(value = "/tourChartJson" , produces = "application/json;charset=utf-8")
	public String busan(int num) {
		//1. �ڵ鸵�� ������ VO�� ����
		SurveyVO vo = surveyService.adminDetail(num);
		
		//2. survey ���� ���� => String
		//{sub:���ɴ뺰~}
		String subject = vo.getSub();
		
		//3. survey ������ ���� => Map
		Map<String, Integer> map = new HashMap<String, Integer>();
		//3-1. foreach������ survey ������ map �ȿ� ����
		//{20��:500},{30��:500}...
		//SurveyVO�ȿ� List ����Ǿ����Ƿ� SurveyContentVO�� �� ���� => vo.getSubvey()
		for (SurveyContentVO e : vo.getSubvey()) {
			//key : e.getSurveytitle()
			//value : e.getSurveycnt()
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		
		//4. return��ȯ ���� ����� ���� => String
		String result = null;
		
		//5. ObjectMapper ���� : ��ü�� ���ڿ��� ��ȯ => JSON?
		ObjectMapper mapper = new ObjectMapper();

		//6. result�� ���ڿ��� ��ȯ�� ��(=Map_survey ������) ���� => try/catch
		try {
			//{"30��":100,"20��":550,"50��":300,"40��":150,"60��":350}
			result = mapper.writeValueAsString(map);
			
		//7. result�� JSON�� ���� �� �ִ� ���·� ���� �� ����(�ڵ鸵)
			//���� : [{"sub":"����"},map]
			result = "[{\"sub\":\""+ vo.getSub() +"\"},"+result+"]";
			System.out.println(result); //test
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		return result;
	}

}
