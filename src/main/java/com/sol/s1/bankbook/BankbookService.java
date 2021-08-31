package com.sol.s1.bankbook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class BankbookService {
	private BankBookDAO bankBookDAO;
	
	
	public void setBankBookDAO(BankBookDAO bankBookDAO) {
		this.bankBookDAO = bankBookDAO;
	}


	public ArrayList<BankBookDTO> getList() {
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		return ar;
	}
}
