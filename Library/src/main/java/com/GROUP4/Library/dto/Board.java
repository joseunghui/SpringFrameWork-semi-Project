package com.GROUP4.Library.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Board {
	
	private int BNo;
	private String BWriter;
	private String BTitle;
	
	private String BContent;
	private String BDate;
	private MultipartFile BFile;
	private String BFileName;
}
