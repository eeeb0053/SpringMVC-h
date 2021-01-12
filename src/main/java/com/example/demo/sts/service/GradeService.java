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
    
    public void  insertMany(int count) {
    	List<Grade> list = new ArrayList<Grade>();
    	Grade g = null;
    	
    	for(int i = 0; i < 100; i++) {
    		g = dummy.makeGrade();
    		g.setStuNum(i);
    		list.add(g);
    	}
    	gradeMapper.insertMany(list);
 	
    }
}
