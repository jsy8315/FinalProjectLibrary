package com.libraryPlus;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.io.FileReader;
import java.time.LocalDate;

public class TotalRecorder implements Recorder {

	@Override
	public void add() { 	
		// Create 대출, 반납 이력추가
		// 연장횟수, 대출날짜(오늘날짜), 책 id, 회원 id, 기본 반납예정날짜
		String filePath = "C:\\Users\\Documents\\GitHub\\FinalProjectLibrary\\src\\com\\library\\record.csv";
		
		//id값을 또 입력받아야함.....흠.....
        Scanner sc1 = new Scanner(System.in);
		System.out.println("회원 id를 입력하세요");
		int bookId = sc1.nextInt();
		Scanner sc2 = new Scanner(System.in);
		System.out.println("책 id를 입력하세요");
		int memberId = sc2.nextInt(); 
        
        // 대출일을 오늘 날짜로 설정
        Date loanDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String lendDay = dateFormat.format(loanDate);
        
        // 반납일을 2주 후로 설정 (기본)
        Calendar returnDate = Calendar.getInstance();
        returnDate.setTime(loanDate);
        returnDate.add(Calendar.DATE, 14);
        String defaultReturnDay = dateFormat.format(returnDate.getTime());
        
        // record.csv 파일에 대출 이력 저장
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.append("0," + lendDay + "," + bookId + "," + memberId + "," + defaultReturnDay + "\n");
            writer.close();
            System.out.println("record.csv 파일에 대출 이력이 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("record.csv 파일에 대출 이력을 저장하는 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
	}

	@Override
	public int search() {
		// 대출 테이블을 조회하여 memberID가 빌린 책의 bookID가 일치하고 대출 중이면 1, 둘이 일치하지 않으면 0 반환
		return 0;
	}

	@Override
	public void update() {	
	}
	
	public void extendupdate() { // 연장처리
		// 연장처리
		// 해당 책을 조회하고
		// 그 책
		// 연장횟수를 1로 변경, 대출날짜(오늘날짜), 책 id, 회원 id, 연장 날짜로 바꾸기, 연장횟수 1이라 표시
	}

	@Override
	public void delete() {	// Delete 이력삭제(안쓸거임, 이력 다 기록되게 설정할거니까)
		
	}

}
