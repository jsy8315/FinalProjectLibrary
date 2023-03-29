package com.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public interface Recorder {
	// Create 대출 기록 생성
	public void add();
	
	// Read 대출반납 이력조회
	public void search();
	
	// Update 반납처리
	public void update();
	
	// Delete 이력삭제(안쓸거임, 이력 다 기록되게 설정할거니까)
	public void delete();
}
