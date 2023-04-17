package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//년 월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC { // http://localhost:8181/ch2/getYoilMVC?year=2021&month=10&day=1
//	public static void main(String[] args) {
	@RequestMapping("/getYoilMVC")
//	public void main(HttpServletRequest request,HttpServletResponse response)throws IOException {
	public ModelAndView main(int year, int month, int day) throws IOException {
		
		//1.생
		ModelAndView mv=new ModelAndView();
		mv.setViewName("yoilError");
		
		// 2. 유효성 검사
		if (!isValid(year, month, day))
			return mv;

		// 3. 요일 계산
		char yoil = getYoil(year, month, day);

		// 4. 모델에 저장
		mv.addObject("year", year);
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("yoil", yoil);
		
		//5. 결과를 보여줄 view를 지정
		mv.setViewName("yoil");
		
		return mv;

	}

	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요
		return " 일월화수목금토".charAt(dayOfWeek);
	}
}
