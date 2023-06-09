package com.library;

import java.util.Date;

public class Record {
	private int extendCount; // 연장횟수, 첫 대출시 0부여
	private Date lendDay; // 대출날짜
	private int bookId; // 책 등록번호 id
	private int memberId; // 회원 등록번호 id
	private Date defaultReturnDay; // 기본 반납 날짜
	private Date realReturnDay; // 실제 반납 날짜
	private Date extendedReturnDay; // 연장된 반납 날짜
	
	public Record(int extendCount, Date lendDay, int bookId, int memberId, Date defaultReturnDay) {
		this.extendCount = extendCount;
		this.lendDay = lendDay;
		this.bookId = bookId;
		this.memberId = memberId;
		this.defaultReturnDay = defaultReturnDay;
	}	
	
	
	// getter & setter 만들기
	public int getExtendCount() {
		return extendCount;
	}

	public void setExtendCount(int extendCount) {
		this.extendCount = extendCount;
	}

	public Date getLendDay() {
		return lendDay;
	}

	public void setLendDay(Date lendDay) {
		this.lendDay = lendDay;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Date getDefaultReturnDay() {
		return defaultReturnDay;
	}

	public void setDefaultReturnDay(Date defaultReturnDay) {
		this.defaultReturnDay = defaultReturnDay;
	}

	public Date getRealReturnDay() {
		return realReturnDay;
	}

	public void setRealReturnDay(Date realReturnDay) {
		this.realReturnDay = realReturnDay;
	}

	public Date getExtendedReturnDay() {
		return extendedReturnDay;
	}

	public void setExtendedReturnDay(Date extendedReturnDay) {
		this.extendedReturnDay = extendedReturnDay;
	}
}
