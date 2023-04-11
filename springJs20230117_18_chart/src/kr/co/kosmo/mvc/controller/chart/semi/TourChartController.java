package kr.co.kosmo.mvc.controller.chart.semi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//tchart/busan

@Controller
@RequestMapping(value = "/tchart")
public class TourChartController {
	
	@GetMapping(value = "/busan")
	public String tourChartBusan() {
		return "tourChart/tChart_busan";
	}

}
