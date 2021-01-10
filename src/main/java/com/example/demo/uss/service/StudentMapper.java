package com.example.demo.uss.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
	public int insert(Student student);
	public Student login(Student student);
	public Student selectById(String userid);
	public int update(Student student);
	public int delete(Student student);
	public void truncate(HashMap<String, String> map);
	public int count(HashMap<String, String> map);
	public List<Student> selectAll(HashMap<String, String> map);
}
