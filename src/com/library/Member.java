package com.library;

import java.util.Date;

public class Member {
	private int id; // 회원 등록시 부여되는 id, 회원 등록번호
	private String name;
	private String address;
	private String phonenumber;
	private Date birthday;
	private Date memberday;
	private boolean lendPossible;
	
	public Member(int id, String name, String address, String phonenumber, Date birthday, Date memberday,  boolean lendPossible) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.birthday = birthday;
		this.memberday = memberday;
		this.lendPossible = lendPossible;
	}
	
	@Override
	public String toString() {
		return "회원 등록 번호 : " + id + ", 이름 : " + name + ", 주소 : " + address + " , 전화번호 : " + phonenumber +
				 " , 생년월일 : " + birthday + " , 가입날짜 : " + memberday;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public boolean isLendPossible() {
		return lendPossible;
	}
	public void setLendPossible(boolean lendPossible) {
		this.lendPossible = lendPossible;
	}
}
