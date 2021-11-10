package com.GROUP4.Library.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Book {

	private String KNo, KName, KWriter, KContent, KProfileName, KCheckin;
	private MultipartFile MProfile;
	private String NowTime, ReturnTime;
}