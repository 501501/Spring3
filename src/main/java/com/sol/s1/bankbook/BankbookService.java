package com.sol.s1.bankbook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankbookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	public ArrayList<BankBookDTO> getList(){
		return bankBookDAO.getList();
	}
}
