package com.example.demo.sym.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component @Data @AllArgsConstructor @Lazy @NoArgsConstructor
public class Teacher{
	private int teaNum, subNum;
    private String name, email, password, profileImg;
    public Teacher(String name, String email, String password, String profileImg, int subNum) {
    	this.name = name;
    	this.email = email;
    	this.password = password;
    	this.profileImg = profileImg;
    	this.subNum = subNum;
    }
}
/*
create table teachers(
	tea_num int primary key,
	name varchar2(20),
	email varchar2(20),
	password varchar2(20),
	subject varchar2(20),
	profile_img varchar2(200)
	)
*/
