package com.example.demo.uss.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.utl.DummyGenerator;
import com.example.demo.cmm.utl.Pagination;
import com.example.demo.uss.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService{
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    DummyGenerator dummy;
    
    @Transactional
    public int insertMany(int count) {
    	for(int i = 0; i < count; i++) {
    		studentMapper.insert(dummy.makeStudent());
    	}
    	return count();    	
    }
    
    @Transactional
    public int truncate() {
    	var map = new HashMap<String, String>();
    	map.put("TRUNCATE_STUDENTS", Sql.TRUNCATE.toString()+"Students");
    	studentMapper.truncate(map);
    	return count() != 0 ? 0 : 1;
    }
    
    public int count() {
    	var map = new HashMap<String,String>();
    	map.put("COUNT_STUDENTS", Sql.TOTAL_COUNT.toString()+"students");
    	return studentMapper.count(map);
    }

    public List<Student> list(Pagination page){
    	return studentMapper.list().stream()
    			.sorted(comparing(Student::getStuNum).reversed())
    			.skip(page.getPageSize() * (page.getPageNum()-1))
    			.limit(page.getPageSize())
    			.collect(Collectors.toList());
    }

    public List<Student> selectBirthday(Pagination page){
    	return studentMapper.list().stream()
    			.sorted(comparing(Student::getStuNum).reversed())
    			.skip(page.getPageSize() * (page.getPageNum()-1))
    			.limit(page.getPageSize())
    			.collect(Collectors.toList());
    }
}
