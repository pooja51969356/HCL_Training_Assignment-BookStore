package com.learn.service;

import java.util.List;

import com.learn.dto.BookRequestDto;
import com.learn.dto.BookResponseDto;

public interface BookService {
	
	BookResponseDto addBookDetail(BookRequestDto bookRequestDto);
	
	BookResponseDto updateBookDetail(BookRequestDto bookRequestDto);
	
	String deleteBookDetail(Integer book_id);
	
	BookResponseDto selectBookDetailByBookId(Integer bookId);
	
	List<BookResponseDto> selectBookDetailByPublisher(String publisherName);
	
	List<BookResponseDto> selectBookDetailByBookNameAndBookAuther(String bookName,String bookAuther);
	
	List<BookResponseDto> selectBookDetailByBookNameOrBookAuther(String bookName,String bookAuther);
	
	List<BookResponseDto> selectBookDetailByBookIdLessThenOrEqualsTo(Integer bookIdRange);
	
	List<BookResponseDto> selectBookDetailByBookAutherStartingWith(String autherStartingName);
	
	List<BookResponseDto> selectBookDetailByBookNameContaining(String bookNameContaingLetter);
	
	
	
	

}
