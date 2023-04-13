package com.libraryPlus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class FileManager implements Manager {

	@Override
	public void add() { // csv 파일 만들기
		
	}

	@Override
	public int search() { //csv 파일에서 조회하기
		return 0;
	}

	@Override
	public void update() { //csv 파일 수정하기
		
	}
	
	public void lendMemberLendPossibleUpdate(int outputMemberId) { 
		// 빌려주기 : 키워드로 outputMemberId를 넣으면 lendPossible을 1 - > 0로 만들어줌
		
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
			// BufferedReader 객체 생성, 읽을 파일의 경로인 filePath
			br = new BufferedReader(new FileReader(filePath));
			
			// 파일의 내용 한줄씩 읽음
			while ((line = br.readLine()) != null) {
				
				// CSV 데이터 파싱: 읽어들인 CSV 데이터는 각 라인을 쉼표로 구분한
				// 문자열 배열로 변환
				String[] data = line.split(delimiter);
				if (outputMemberId == Integer.parseInt(data[0])) { // 일치하면
					data[6] = "0"; // lendPossible을 0으로 바꿈
				}
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
	
	public void returnMemberLendPossibleUpdate(int outputMemberId) { 
		// 반납하기 : 키워드로 outputMemberId를 넣으면 lendPossible을 0 -> 1로 만들어줌
		
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
			// BufferedReader 객체 생성, 읽을 파일의 경로인 filePath
			br = new BufferedReader(new FileReader(filePath));
			
			// 파일의 내용 한줄씩 읽음
			while ((line = br.readLine()) != null) {
				
				// CSV 데이터 파싱: 읽어들인 CSV 데이터는 각 라인을 쉼표로 구분한
				// 문자열 배열로 변환
				String[] data = line.split(delimiter);
				if (outputMemberId == Integer.parseInt(data[0])) { // 일치하면
					data[6] = "1"; // lendPossible을 0으로 바꿈
				}
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
		
	public void lendBookLendPossibleUpdate(int outputBookId) { 
		// 빌려주기 : 키워드로 outputMemberId를 넣으면 lendPossible을 1 -> 0로 만들어줌
		
		// file 경로 설정
		String filePath = "C:\\Users\\Documents\\GitHub\\FinalProjectLibrary\\src\\com\\library\\books.csv";
        
		// BufferedReader는 객체를 선언할때, 초기값을 null로 설정해주는 코드
		// 이렇게 변수를 미리 선언하고 초기화하면, 나중에 예외처리 시 BufferedReader객체가 
		// 정상적으로 생성되지 않았을 경우에 대비하여 null 여부를 검사할 수 있음
		BufferedReader br = null;
		
		//line변수는 csv파일을 읽어들일떄, 한줄씩 읽어들인 문자열을 저장하는 변수
        String line = "";
        
        // csv파일에서 각 데이터 구분 기준 지정, 여기서는 쉼표
        String delimiter = ",";
        
		try {
			// BufferedReader 객체 생성, 읽을 파일의 경로인 filePath
			br = new BufferedReader(new FileReader(filePath));
			
			// 파일의 내용 한줄씩 읽음
			while ((line = br.readLine()) != null) {
				
				// CSV 데이터 파싱: 읽어들인 CSV 데이터는 각 라인을 쉼표로 구분한
				// 문자열 배열로 변환
				String[] data = line.split(delimiter);
				if (outputBookId == Integer.parseInt(data[0])) { // 일치하면
					data[5] = "0"; // lendPossible을 0으로 바꿈
				}
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
	
	public void returnBookLendPossibleUpdate(int outputBookId) { 
		// 반납하기 : 키워드로 outputMemberId를 넣으면 lendPossible을 0 -> 1로 만들어줌
		
		// file 경로 설정
		String filePath = "C:\\Users\\Documents\\GitHub\\FinalProjectLibrary\\src\\com\\library\\books.csv";
        
		// BufferedReader는 객체를 선언할때, 초기값을 null로 설정해주는 코드
		// 이렇게 변수를 미리 선언하고 초기화하면, 나중에 예외처리 시 BufferedReader객체가 
		// 정상적으로 생성되지 않았을 경우에 대비하여 null 여부를 검사할 수 있음
		BufferedReader br = null;
		
		//line변수는 csv파일을 읽어들일떄, 한줄씩 읽어들인 문자열을 저장하는 변수
        String line = "";
        
        // csv파일에서 각 데이터 구분 기준 지정, 여기서는 쉼표
        String delimiter = ",";
        
		try {
			// BufferedReader 객체 생성, 읽을 파일의 경로인 filePath
			br = new BufferedReader(new FileReader(filePath));
			
			// 파일의 내용 한줄씩 읽음
			while ((line = br.readLine()) != null) {
				
				// CSV 데이터 파싱: 읽어들인 CSV 데이터는 각 라인을 쉼표로 구분한
				// 문자열 배열로 변환
				String[] data = line.split(delimiter);
				if (outputBookId == Integer.parseInt(data[0])) { // 일치하면
					data[5] = "1"; // lendPossible을 0으로 바꿈
				}
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

	@Override
	public void delete() { // csv 파일 삭제하기
		
	}
	
	public int memberIdSearch(String a, String b) { 
		// member.csv을 열어서 회원번호를 조회하고, 반환하는 메서드 추가
		// 키워드로 이름, 전화번호를 넣으면 (String a, String b) id를 찾아내줌
	    // 회원아니면  outputMemberId = -1로 리턴하고, 
	    // 회원이면 그 사람의 memberId를 outputMemberId로 리턴함
		
		int outputMemberId = -1; // 일단 outputMemberId를 -1로 설정
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
			// BufferedReader 객체 생성, 읽을 파일의 경로인 filePath
			br = new BufferedReader(new FileReader(filePath));
			
			// 파일의 내용 한줄씩 읽음
			while ((line = br.readLine()) != null) {
				
				// CSV 데이터 파싱: 읽어들인 CSV 데이터는 각 라인을 쉼표로 구분한
				// 문자열 배열로 변환
				String[] data = line.split(delimiter);
				if (a == data[1] && b == data[3]) { // 이름과 전화번호로 받음
					outputMemberId = Integer.parseInt(data[0]); //id를 c로 저장
					break;
				}
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
	    if (outputMemberId == -1) { // 원하는 값이 없다면 오류 메시지 출력
	        System.out.println("회원이 아닙니다.");
	    }
	    return outputMemberId; 
	    // 회원아니면  outputMemberId = -1로 리턴하고, 
	    // 회원이면 그 사람의 memberId를 outputMemberId로 리턴함
	}
	
	public int booksIdSearch(String a, String b) { 
		// books.csv을 열어서  책번호를 조회하고, outputBookId를 반환하는 메서드 추가
		// 키워드로 책제목, 저자를 넣으면 (String a, String b) id를 찾아내줌
		int outputBookId = -1;
		// file 경로 설정
		String filePath = "C:\\Users\\Documents\\GitHub\\FinalProjectLibrary\\src\\com\\library\\books.csv";
        
		// BufferedReader는 객체를 선언할때, 초기값을 null로 설정해주는 코드
		// 이렇게 변수를 미리 선언하고 초기화하면, 나중에 예외처리 시 BufferedReader객체가 
		// 정상적으로 생성되지 않았을 경우에 대비하여 null 여부를 검사할 수 있음
		BufferedReader br = null;
		
		//line변수는 csv파일을 읽어들일떄, 한줄씩 읽어들인 문자열을 저장하는 변수
        String line = "";
        
        // csv파일에서 각 데이터 구분 기준 지정, 여기서는 쉼표
        String delimiter = ",";
        
		try {
			// BufferedReader 객체 생성, 읽을 파일의 경로인 filePath
			br = new BufferedReader(new FileReader(filePath));
			
			// 파일의 내용 한줄씩 읽음
			while ((line = br.readLine()) != null) {
				
				// CSV 데이터 파싱: 읽어들인 CSV 데이터는 각 라인을 쉼표로 구분한
				// 문자열 배열로 변환
				String[] data = line.split(delimiter);
				if (a == data[1] && b == data[2] && data[6] == "1") { // 책제목과 저자로 받음
					// 대출 가능하면 진행
					outputBookId = Integer.parseInt(data[0]); //id를 c로 저장
					break;
				} else if (a == data[1] && b == data[2] && data[6] != "1") {
					System.out.println("대출 불가 도서입니다. 현재 대출 중입니다.");
				} else {
					System.out.println("보유 중인 도서가 아닙니다.");
				}
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
	    return outputBookId;
	}
}
