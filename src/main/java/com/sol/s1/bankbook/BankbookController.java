package com.sol.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sol.s1.util.Pager;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {
	//pojo (plain old java object)
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping("bankbookList")
	public ModelAndView list(ModelAndView mv, Pager pager) {
		List<BankBookDTO> ar = bankBookService.getList(pager);
		
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
		mv.setViewName("bankbook/bankbookList");
		return mv;
	}
	
	@RequestMapping("bankbookSelect")
	//방법1. 매개변수에 HttpServletRequest 선언
	//방법2. 매개변수에 파라미터 선언 
	public void select(BankBookDTO bankBookDTO, Model model) {
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}
	
	@RequestMapping(value = "bankbookInsert", method = RequestMethod.GET)
	public void insert() {}
	
	@RequestMapping(value = "bankbookInsert", method = RequestMethod.POST)
	public String insert(BankBookDTO bankBookDTO) {
		int result = bankBookService.setInsert(bankBookDTO);
		
		return "redirect:./bankbookList";
	}
	
	@RequestMapping("bankbookDelete")
	public String delete(Long bookNumber) {
		int result = bankBookService.setDelete(bookNumber);
		
		return "redirect:./bankbookList";
	}
	
	@RequestMapping(value = "bankbookUpdate", method = RequestMethod.GET)
	public ModelAndView update(BankBookDTO bankBookDTO) {
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bankbook/bankbookUpdate");
		mv.addObject("dto", bankBookDTO);
		
		return mv;
	}
	
	@RequestMapping(value = "bankbookUpdate", method = RequestMethod.POST)
	public ModelAndView update(BankBookDTO bankBookDTO, ModelAndView mv) {
		int result = bankBookService.setUpdate(bankBookDTO);
		mv.setViewName("redirect:./bankbookList");
		return mv;
	}
}
