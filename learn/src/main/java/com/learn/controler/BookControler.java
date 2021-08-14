/**
 * 
 */
package com.learn.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.dto.BookRequestDto;
import com.learn.dto.BookResponseDto;
import com.learn.service.BookService;

/**
 * @author pooja
 *
 */
@RestController
public class BookControler {
	
	@Autowired
	BookService bookService;

	@PostMapping(path = "/book")
	BookResponseDto addBookDetail(@RequestBody BookRequestDto bookRequestDto) {
		return bookService.addBookDetail(bookRequestDto);
	}
	
	@PutMapping(path = "/book")
	BookResponseDto updateBookDetail(@RequestBody BookRequestDto bookRequestDto) {
		return bookService.updateBookDetail(bookRequestDto);
	}
	
	@DeleteMapping(path = "/book/book-id/{bookId}")
	String deleteBookDetail(@PathVariable Integer bookId) {		
		return bookService.deleteBookDetail(bookId);
	}
	
	@GetMapping(path = "/book/{bookId}")
	BookResponseDto selectBookDetailByBookId(@PathVariable Integer bookId) {
		return bookService.selectBookDetailByBookId(bookId);
	}
	
	@GetMapping(path = "/book/publisher/{publisherName}")
	List<BookResponseDto> selectBookDetail(@PathVariable String publisherName) {
		return bookService.selectBookDetailByPublisher(publisherName);
	}
	
	@GetMapping(path = "/book/book-name/{bookName}/and/book-auther/{bookAuther}")
	List<BookResponseDto> selectBookDetailByBookNameAndBookAuther(@PathVariable String bookName,@PathVariable String bookAuther) {
		return bookService.selectBookDetailByBookNameAndBookAuther(bookName, bookAuther);
	}
	
	@GetMapping(path = "/book/book-name/{bookName}/or/book-auther/{bookAuther}")
	List<BookResponseDto> selectBookDetailByBookNameOrBookAuther(@PathVariable String bookName,@PathVariable String bookAuther) {
		return bookService.selectBookDetailByBookNameOrBookAuther(bookName, bookAuther);
	}
	
	@GetMapping(path = "/book/book-id/{bookId}")
	List<BookResponseDto> selectBookDetailByBookIdLessThenOrEqualsTo(@PathVariable Integer bookId) {
		return bookService.selectBookDetailByBookIdLessThenOrEqualsTo(bookId);
	}
	
	@GetMapping(path = "/book/book-name/{autherStartingName}")
	List<BookResponseDto> selectBookDetailByBookAutherStartingWith(@PathVariable String autherStartingName) {
		return bookService.selectBookDetailByBookAutherStartingWith(autherStartingName);
	}
	
	@GetMapping(path = "/book/book-name/{bookNameContaingLetter}")
	List<BookResponseDto> selectBookDetailByBookNameContaining(@PathVariable String bookNameContaingLetter) {
		return bookService.selectBookDetailByBookNameContaining(bookNameContaingLetter);
	}
	
	

	
}
