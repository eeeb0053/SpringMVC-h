package com.example.demo.sym.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.cmm.utl.DummyGenerator;
import com.example.demo.sts.service.Grade;

@Service
public class TeacherService{
    @Autowired TeacherMapper teacherMapper;
    @Autowired DummyGenerator dummy;
    
    @Transactional
    public void  insertMany(int count) {
    	var tlist = new ArrayList<Teacher>();
    	Teacher t = null;
    	for(int i = 0; i < count; i++) {
    		t = dummy.makeTeacher();
    		tlist.add(t);
    	}
    	teacherMapper.insertMany(tlist);
    }
    
    public int register(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }
    

}
