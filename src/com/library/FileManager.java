package com.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class FileManager implements Manager {

	@Override
	public void add() { // csv 파일 만들기
		
	}

	@Override
	public void search() { //csv 파일에서 조회하기
	}

	@Override
	public void update() { //csv 파일 수정하기
		
	}

	@Override
	public void delete() { // csv 파일 삭제하기
		
	}
	
	public void memberCsvSearch() { // member.csv을 조회하는 메서드 추가
		
		//
		
		
		// file 경로 설정
		String filePath = "C:\\Users\\Documents\\GitHub\\FinalProjectLibrary\\src\\com\\library\\member.csv";
        
		// BufferedReader는 객체를 선언할때, 초기값을 null로 설정해주는 코드
		// 이렇게 변수를 미리 선언하고 초기화하면, 나중에 예외처리 시 BufferedReader객체가 
		// 정상적으로 생성되지 않았을 경우에 대비하여 null 여부를 검사할 수 있음
		BufferedReader br = null;
		
		//line변수는 csv파일을 읽어들일떄, 한줄씩 읽어들인 문자열을 저장하는 변수
        String line = "";
        
        // csv파일에서 각 데이터 구분 기준 지정, 여기서는 쉼표
        String delimiter = ",";
        
		try {
			// BufferedReader 객체 생성
			br = new BufferedReader(new FileReader(filePath));
			
			// 파일의 내용 한줄씩 읽음
			while ((line = br.readLine()) != null) {
				
				// CSV 데이터 파싱: 읽어들인 CSV 데이터는 각 라인을 쉼표로 구분한
				// 문자열 배열로 변환
				String[] data = line.split(delimiter);
				
			}
		} catch (IOException e) {
            e.printStackTrace();
        } finally {
        	// 파일 입력 스트림 닫기
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
