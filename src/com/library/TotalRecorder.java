package com.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;

public class TotalRecorder implements Recorder {

	@Override
	public void add() { 	
		// Create 대출, 반납 이력추가
		// 연장횟수, 대출날짜(오늘날짜), 책 id, 회원 id, 기본 반납예정날짜
		String filePath = "C:\\Users\\Documents\\GitHub\\FinalProjectLibrary\\src\\com\\library\\record.csv";
		String line;
		String data;
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		int a;
		int b;
		
		while ((line = br.readLine()) != null) {
		    data += line + "\n";
		}
		data += "0," + LocalDate.now() + "," + int a + "," + int b + ",defaultReturnDay,extendedReturnDay,realReturnDay\n";
		br.close();
		
		FileWriter fw = new FileWriter("record.csv");
		fw.write(data);
		fw.close();

	}

	@Override
	public void search() {	// Read 대출반납 이력조회
		// 기록 id return
	}

	@Override
	public void update() {	// Update 대출반납 이력수정(연장)
		// 반납 날짜 기록
		// 연장횟수, 대출날짜(오늘날짜), 책 id, 회원 id, 기본 반납예정날짜 , 실제 반납 날짜 기록
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
