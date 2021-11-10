package com.GROUP4.Library.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Member {
	
	private int MNo;
	private String MId;
	private String MPw;
	
	private String MName;
	private String MBirth;
	private String MGender;
	
	private String MPhone;
	private String MEmail;
	private String MAddr;
	
	private MultipartFile MProfile;
	private String MProfileName;
	
	private String addr1, addr2, addr3;
	private int year,month,day;

}
