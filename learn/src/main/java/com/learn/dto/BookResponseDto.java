package com.learn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookResponseDto {
	
	private int bookId;
	private String bookName;
	private String bookTitle;
	private String publisher;
	private String auther;

}
