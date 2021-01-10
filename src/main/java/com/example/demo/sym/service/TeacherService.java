package com.example.demo.sym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService{
    @Autowired TeacherMapper teacherMapper;

    public int register(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    public List<?> list() {
        return teacherMapper.selectAll();
    }

    public Teacher detail(String teaNum) {
        return teacherMapper.selectById(teaNum);
    }

    public int update(Teacher teacher) {
        return teacherMapper.update(teacher);
    }

    public int delete(Teacher teacher) {
        return teacherMapper.delete(teacher);
    }
    
}
