package com.sol.s1.bankbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {
	//pojo (plain old java object)
	
	@RequestMapping(value = "bankbookList.do", method = RequestMethod.GET)
	public String list() {
		System.out.println("bankbook list");
		return "bankbook/bankbookList";
	}
	
	@RequestMapping("bankbookSelect.do")
	//방법1. 매개변수에 HttpServletRequest 선언
	//방법2. 매개변수에 파라미터 선언 
	public String select(int num, String name) {
		System.out.println("Value: "+num);
		System.out.println("Name: "+name);
		return "bankbook/bankbookSelect";
	}
}
