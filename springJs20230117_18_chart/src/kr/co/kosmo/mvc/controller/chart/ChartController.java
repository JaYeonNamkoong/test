package kr.co.kosmo.mvc.controller.chart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//chart/studentchart
@Controller
@RequestMapping(value = "/chart")
public class ChartController {

	@GetMapping(value = "/studentchart")
	public String studentchart() {
		return "chart/ex5_customJsonStudent";
	}

	@GetMapping(value = "/donutchart")
	public String donutchart() {
		return "chart/ex5_donutChart";
	}
	
	@GetMapping(value = "/deptJsonDemo")
	public String chart1() {
		return "chart/deptJsonDemo";
	}

	@GetMapping(value = "/memberlistJson")
	public String chart2() {
		return "chart/memberJsonDemo";
	}
	
	//donut
	@GetMapping(value = "/surveyDonutChartAjax")
	public String chart3() {
		return "chart/surveyDonutChartAjax";
	}
}
