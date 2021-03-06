package com.example.demo.uss.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component @Data @AllArgsConstructor @Lazy @NoArgsConstructor
public class Student{
	private int stuNum, mgrNum;
    private String userid, password, name, birthday, gender, regDate, profileImg;
    public Student(String userid, String password, String name, String birthday,
    			   String gender, String regDate, String profileImg, int mgrNum) {
    	this.userid = userid;
    	this.password = password;
    	this.name = name;
    	this.birthday = birthday;
    	this.gender = gender;
    	this.regDate = regDate;
    	this.profileImg = profileImg;
    	this.mgrNum = mgrNum;
    }
}
/*
create table students(
	stu_num int primary key,
	userid varchar2(20),
	password varchar2(20),
	name varchar2(20),
	ssn varchar2(20),
	reg_date varchar2(20),
	subject varchar2(20),
	profile_img varchar2(200),
	tea_num int,
	constraint students_fk foreign key(tea_num) references teachers(tea_num)
	)
 */