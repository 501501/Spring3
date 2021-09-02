package com.sol.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sol.s1.MyJunitTest;

public class BankBookDAOTest extends MyJunitTest {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void setDeleteTest() {
		int result = bankBookDAO.setDelete(49L);
		assertEquals(1, result);
	}
	
	//@Test
	public void setInsertTest() {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName("Spring");
		bankBookDTO.setBookRate(3.35);
		bankBookDTO.setBookSale(1);
		int result = bankBookDAO.setInsert(bankBookDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void getListTest() {
		List<BankBookDTO> ar = bankBookDAO.getList();
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void getSelectTest() {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(1);
		bankBookDTO = bankBookDAO.getSelect(bankBookDTO);
		System.out.println(bankBookDTO.getBookName());
		assertNotNull(bankBookDTO);
	}

}
