package com.library;

import java.util.Date;

public class Member {
	private int id; // 회원 등록시 부여되는 id, 회원 등록번호
	private String name;
	private String address;
	private Date birthday;
	private boolean lendPossible = true; //빌릴수있는지
}
