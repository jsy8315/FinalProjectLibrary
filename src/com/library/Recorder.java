package com.library;

public interface Recorder {
	// Create 이력추가
	public void add();
	
	// Read 이력조회
	public void search();
	
	// Update 이력수정(연장)
	public void update();
	
	// Delete 이력삭제(안쓸거임, 이력 다 기록되게 설정할거니까)
	public void delete();
}
