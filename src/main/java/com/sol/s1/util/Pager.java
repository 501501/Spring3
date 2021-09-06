package com.sol.s1.util;

public class Pager {
	
	private Long pn;
	private Long perPage;
	
	private Long startRow;
	private Long lastRow;
	
	private Long startNum;
	private Long lastNum;
	
	private Long totalPage;
	
	public void makeRow() {
		this.startRow = (this.getPn() - 1) * this.getPerPage() + 1;
		this.lastRow = this.getPn() * this.getPerPage();
	}
	
	public void makeNum(Long totalCount) {
		// 1. totalCount
		//Long totalCount = 206L;
		
		// 2. totalPage
		totalPage = totalCount / this.getPerPage();
		if (totalCount % this.getPerPage() != 0) {
			//totalPage+=1;
			totalPage++;
		}
		
		// 3.totalBlock 구하기
		Long totalBlock = totalPage / 5;
		if (totalPage%5 != 0) {
			totalBlock++;
		}
		
		// 4. pn으로 curBlock 구하기
		if (totalPage < this.getPn()) {
			this.setPn(totalPage);
		}
		
		Long curBlock = this.getPn()/5;
		if (this.getPn()%5 != 0) {
			curBlock++;
		}
		
		// 5. curBlock으로 시작 번호와 마지막 번호 구하기
		this.startNum = (curBlock-1) * 5 + 1;
		this.lastNum = curBlock*5;
		
		if (curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
	}
	
	public Long getPn() {
		if (this.pn == null || this.pn <= 0) {
			this.pn = 1L;
		}
		return pn;
	}
	
	public void setPn(Long pn) {
		this.pn = pn;
	}
	
	public Long getStartRow() {
		return startRow;
	}
	
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	
	public Long getLastRow() {
		return lastRow;
	}
	
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	
	public Long getPerPage() {
		if (this.perPage == null || this.perPage == 0) {
			this.perPage = 10L;
		}
		return perPage;
	}
	
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public Long getTotalPage() {
		return totalPage;
	}
}
