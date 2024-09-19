package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;


@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository boardRepository;
	
	@Test
	public void 리파지토리객체를가져왓는지확인() {
		System.out.println("boardRepository = " + boardRepository);
	}
	
	@Test
	public void 데이터등록() {
		
		// 생성자를 사용하여 객체 생성
		Board board1 = new Board(0, "1번글", "내용~", null, null);
		
		boardRepository.save(board1);
		
		// bulider를 사용하여 객체 생성
		Board board2 = Board
							.builder()
							.title("2번글")
							.content("내용~")
							.build();
		boardRepository.save(board2);
		// save 함수를 호출하면 insert 또는 update 쿼리가 생성됨.
	}
	
	@Test
	public void 데이터전체조회() {
		
		List<Board> list = boardRepository.findAll();
		
		for (Board board : list) {
			System.out.println(board);
		}
		// findAll 함수를 호출하면 select 쿼리가 생성됨.
	}
	
	@Test
	public void 데이터단건조회() {
		
		Optional<Board> optional = boardRepository.findById(1);
		
		// optional 안에 값이 있는지 확인하고 꺼내기
		if(optional.isPresent() == true) {
			Board board = optional.get();
			System.out.println(board);
		}
//		System.out.println(optional);
//		System.out.println(optional.get());
	}
	
	@Test
	public void 데이터수정() {
		
		// 데이터가 존재하는지 확인
		Optional<Board> result= boardRepository.findById(1);
		Board board = result.get();
		
		// 데이터 일부 변경
		board.setContent("내용이 수정되었습니다~");
		
		// 게시물 업데이트
		boardRepository.save(board);
		
		// 데이터가 존재하면 update 쿼리가 생성됨.
	}
	
	@Test
	public void 데이터삭제() {
		
		boardRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		
		boardRepository.deleteAll();
	}
}
