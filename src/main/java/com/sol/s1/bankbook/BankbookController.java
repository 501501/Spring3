package com.sol.s1.bankbook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {
	//pojo (plain old java object)
	
	@RequestMapping(value = "bankbookList.do", method = RequestMethod.GET)
	public ModelAndView list(Integer [] num, ModelAndView mv) {
		for(Integer i : num) {
			System.out.println(i);
		}
		System.out.println("bankbook list");
		//ModelAndView mv = new ModelAndView();
		mv.setViewName("bankbook/bankbookList");
		return mv;
	}
	
	@RequestMapping("bankbookSelect")
	//방법1. 매개변수에 HttpServletRequest 선언
	//방법2. 매개변수에 파라미터 선언 
	public void select(@RequestParam(defaultValue = "1", value = "n") Integer num, String name, Model model) {
		System.out.println("Value: "+num);
		System.out.println("Name: "+name);
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName("BookName");
		model.addAttribute("test", "iu");
		model.addAttribute("dto", bankBookDTO);
		//return "bankbook/bankbookSelect";
	}
	
	@RequestMapping("bankbookInsert.do")
	public String insert(BankBookDTO bankBookDTO) {
		System.out.println(bankBookDTO.getBookName());
		System.out.println("insert");
		return "redirect:../";
	}
}
