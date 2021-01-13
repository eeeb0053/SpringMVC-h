package com.example.demo.sts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.cmm.utl.DummyGenerator;

@Service
public class GradeService{
    @Autowired GradeMapper gradeMapper;
    @Autowired DummyGenerator dummy;
    
    public void insertMany() {
    	for(int i = 1; i <= 100; i++) {
    		for(int j = 1; j <= 5; j++) {
    			gradeMapper.insert(dummy.makeGrade(i, j));
    		}
    	}
    }
    
    public List<GradeVo> selectAllforExam(String examDate){
    	return gradeMapper.selectJoinAll(examDate);
    }
}
