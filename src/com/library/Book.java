package com.library;

import java.util.Date;

//Book 클래스: 도서 정보를 저장하는 클래스
//test
// test가 안되네
public class Book {
	private int id; // 책 등록시 부여되는 id, 책 등록번호
	private String title;
	private String author;
	private String publisher;
	private Date publishedDay;
	private boolean lendPossible = true;
	
	public Book(int id, String title, String author, String publisher, Date publishedDay, boolean lendPossible) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publishedDay = publishedDay;
		this.lendPossible = lendPossible;
	}
	
	@Override
	public String toString() {
		return "책 등록 번호 : " + id + ", 책 제목 : " + title + ", 저자 : " + author + ", 출판사 : "
				 + ", 출간일 : " + publishedDay;
	}
	
	
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishedDay() {
		return publishedDay;
	}

	public void setPublishedDay(Date publishedDay) {
		this.publishedDay = publishedDay;
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
