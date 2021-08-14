/**
 * 
 */
package com.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.model.BookModel;

/**
 * @author pooja
 *
 */
public interface BookRepository extends JpaRepository<BookModel, Integer> {

	List<BookModel> findByBookNameAndAuther(String bookName, String bookAuther);
	
	List<BookModel> findByBookNameOrAuther(String bookName, String bookAuther);
	
	List<BookModel> findByBookIdLessThanEqual(Integer bookId);
	
	List<BookModel> findByAutherStartingWith(String autherStartingName);
	
	List<BookModel> findByBookNameContaining(String bookNameContaingLetter);
	
	List<BookModel> findByPublisher(String publisherName);
	
	
	

}
