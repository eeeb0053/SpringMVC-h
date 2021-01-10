package com.example.demo.sym.service;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper {
	public int insert(Teacher teacher);
	public List<Teacher> selectAll();
	public Teacher selectById(String teaNum);
	public int update(Teacher teacher);
	public int delete(Teacher teacher);
	public Teacher access(Teacher teacher);
}
