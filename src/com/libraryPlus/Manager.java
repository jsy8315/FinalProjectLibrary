package com.libraryPlus;

//회원관리, 도서관리, 대출반납 관리에서 쓸 Manage만들기
public interface Manager {
	
	// Create 회원은 가입, 도서는 등록, 대출이력 기입(대출처리), 반납 이력 기입(반납처리)
	public void add();
	
	// Read 회원 조회, 도서 조회, 대출회원/책 조회, 반납회원/책 조회 해서 
	// int 값을 리턴하기
	public int search();
	
	// Update 회원정보 수정, 도서 정보 수정, 대출정보수정, 반납정보수정
	public void update();
	
	// Delete 회원 삭제, 도서 삭제, 대출내역수정, 반납내역수정
	public void delete();

	
}
