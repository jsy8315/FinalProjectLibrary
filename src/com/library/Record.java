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
	
	public Record()
}
