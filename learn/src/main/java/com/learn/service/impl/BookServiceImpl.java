package com.learn.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.dto.BookRequestDto;
import com.learn.dto.BookResponseDto;
import com.learn.exception.NotFoundException;
import com.learn.model.BookModel;
import com.learn.repository.BookRepository;
import com.learn.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public BookResponseDto addBookDetail(BookRequestDto bookRequestDto) {
		
		BookModel bookModelResponse=bookRepository.save(getBookDetail(bookRequestDto));
		
		
		return prepareBookDetailForResponse(bookModelResponse);
	}

	private BookModel getBookDetail(BookRequestDto bookRequestDto) {
		
		BookModel bookModel=new BookModel(bookRequestDto.getBookId(), bookRequestDto.getBookName(), bookRequestDto.getBookTitle(), bookRequestDto.getPublisher(), bookRequestDto.getAuther());
		
		
		return bookModel;
	}
	
	private BookResponseDto prepareBookDetailForResponse(BookModel bookModelResponse) {
		
		BookResponseDto bookResponseDto=new BookResponseDto(bookModelResponse.getBookId(), bookModelResponse.getBookName(), bookModelResponse.getBookTitle(), bookModelResponse.getPublisher(), bookModelResponse.getAuther());
		
		
		return bookResponseDto;
	}
	

	@Override
	public BookResponseDto updateBookDetail(BookRequestDto bookRequestDto) {
		
			BookModel bookModelResponse=bookRepository.save(getBookDetail(bookRequestDto));
		
		return prepareBookDetailForResponse(bookModelResponse);
	}

	@Override
	public String deleteBookDetail(Integer book_id) {
			bookRepository.deleteById(book_id);
		return "Record Deleted Successfully !!!!";
	}

	@Override
	public BookResponseDto selectBookDetailByBookId(Integer bookId) {
		
		Optional<BookModel> bookModelResponse=bookRepository.findById(bookId);
		
		if(bookModelResponse.isPresent())		
			return prepareBookDetailForResponse(bookModelResponse.get());
		else
			throw new IllegalArgumentException("No Record Found For book Id :"+bookId );
	}
	
	@Override
	public List<BookResponseDto> selectBookDetailByPublisher(String publisherName) {
		
		List<BookModel> bookModelResponse=bookRepository.findByPublisher(publisherName);
		if(bookModelResponse!=null && bookModelResponse.isEmpty())		
			return prepareBookDetailForResponseList(bookModelResponse);
		else
			throw new NotFoundException("No Record Found For publisherName :"+publisherName );
	}

	@Override
	public List<BookResponseDto> selectBookDetailByBookNameAndBookAuther(String bookName, String bookAuther) {
		
		List<BookModel> bookModelResponse=bookRepository.findByBookNameAndAuther(bookName,bookAuther);
		if(bookModelResponse!=null && bookModelResponse.isEmpty())		
			return prepareBookDetailForResponseList(bookModelResponse);
		else
			throw new IllegalArgumentException("No Record Found For bookName : "+bookName +" And bookAuther: "+bookAuther );
	}

	@Override
	public List<BookResponseDto> selectBookDetailByBookNameOrBookAuther(String bookName, String bookAuther) {
		
		List<BookModel> bookModelResponse=bookRepository.findByBookNameOrAuther(bookName,bookAuther);
		if(bookModelResponse!=null && bookModelResponse.isEmpty())		
			return prepareBookDetailForResponseList(bookModelResponse);
		else
			throw new IllegalArgumentException("No Record Found For bookName : "+bookName +" Or bookAuther: "+bookAuther );
	}

	@Override
	public List<BookResponseDto> selectBookDetailByBookIdLessThenOrEqualsTo(Integer bookIdRange) {
		List<BookModel> bookModelResponse=bookRepository.findByBookIdLessThanEqual(bookIdRange);
		if(bookModelResponse!=null && bookModelResponse.isEmpty())		
			return prepareBookDetailForResponseList(bookModelResponse);
		else
			throw new IllegalArgumentException("No Record Found " );
	}

	@Override
	public List<BookResponseDto> selectBookDetailByBookAutherStartingWith(String autherStartingName) {
		List<BookModel> bookModelResponse=bookRepository.findByAutherStartingWith(autherStartingName);
		if(bookModelResponse!=null && bookModelResponse.isEmpty())		
			return prepareBookDetailForResponseList(bookModelResponse);
		else
			throw new IllegalArgumentException("No Record Found For match : "+ autherStartingName);
	}
	
	@Override
	public List<BookResponseDto> selectBookDetailByBookNameContaining(String bookNameContaingLetter) {
		List<BookModel> bookModelResponse=bookRepository.findByBookNameContaining(bookNameContaingLetter);
		if(bookModelResponse!=null && bookModelResponse.isEmpty())		
			return prepareBookDetailForResponseList(bookModelResponse);
		else
			throw new IllegalArgumentException("No Record Found For match : "+ bookNameContaingLetter);
	}

	private List<BookResponseDto> prepareBookDetailForResponseList(List<BookModel> bookModelResponse) {
		
		List<BookResponseDto> responseList=new ArrayList<>();
		
		bookModelResponse.forEach( boolModel -> responseList.add( new BookResponseDto(boolModel.getBookId(), boolModel.getBookName(), boolModel.getBookTitle(), boolModel.getPublisher(), boolModel.getAuther()) ) );
		
		
		return responseList;
	}

	
}
