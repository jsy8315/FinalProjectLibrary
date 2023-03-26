package com.library;

import java.util.Date;

//Book 클래스: 도서 정보를 저장하는 클래스
//test
// test가 안되네
public class Book {
	private int id; // 책 등록시 부여되는 id, 책 등록번호
	private String title;
	private String author;
	private Date publishedDay;
	private boolean lendPossible = true;
	
	public Book(String title, String author, Date publishedDay) {
		this.title = title;
		this.author = author;
		this.publishedDay = publishedDay;
	}
	
	@Override
	public String toString() {
		return "책 등록 번호 : " + id + ", 책 제목 : " + title + ", 저자 : "
				 + ", 출간일 : " + publishedDay + ", 대출 가능 여부 : " + lendPossible;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPublishedDate() {
		return publishedDay;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDay = publishedDate;
	}
	public boolean isLendPossible() {
		return lendPossible;
	}
	public void setLendPossible(boolean lendPossible) {
		this.lendPossible = lendPossible;
	}
}
