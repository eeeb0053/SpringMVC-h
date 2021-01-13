package com.example.demo.sts.service;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.demo.uss.service.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Component @AllArgsConstructor @Lazy @NoArgsConstructor
public class Grade{
    private String grade, examDate, passExam;
    private int stuNum, score, grdNum, subNum;
    public Grade(int stuNum, int subNum, String examDate, int score) {
    	this.stuNum = stuNum;
    	this.subNum = subNum;
    	this.examDate = examDate;
    	this.score = score;
    }
}
/*
create table grades2(
	grade_num int primary key auto_increment,
	subject varchar(20),
	score varchar(20),
	grade varchar(20),
	stu_num int,
	exam_date varchar(20),
	constraint grades_fk foreign key(stu_num) references students(stu_num) 
	)
*/
