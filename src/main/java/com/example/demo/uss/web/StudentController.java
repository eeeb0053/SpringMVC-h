package com.example.demo.uss.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.uss.service.Student;
import com.example.demo.uss.service.StudentMapper;
import com.example.demo.uss.service.StudentService;
import static com.example.demo.cmm.utl.Util.*;
@RestController
@RequestMapping("/students")
public class StudentController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired StudentService studentService;
    @Autowired StudentMapper studentMapper;
    @PostMapping("")
    public Messenger register(@RequestBody Student student){
        logger.info("등록하려는 학생 정보: "+student.toString());
        return (studentMapper.insert(student) == 1) ? Messenger.SUCCESS : Messenger.FAILURE;
    }
    @PostMapping("/login")
    public Map<?,?> login(@RequestBody Student student){
        var map = new HashMap<>();
        logger.info("로그인 학생 정보: "+student.toString());
        Student result = studentMapper.login(student);
        map.put("message", (result != null) ? "SUCCESS" : "FAILURE");
        map.put("sessionUser", result);
        logger.info("로그인 성공 정보: "+student.toString());
        return map;
    }
    @GetMapping("/truncate")
    public Messenger truncate(){
    	logger.info("=========== Students Truncated Execute..");
    	return studentService.truncate() == 1 ? Messenger.SUCCESS : Messenger.FAILURE;
    }

    @GetMapping("/insert-many/{count}")
    public String insertMany(@PathVariable String count){
    	logger.info(String.format("=========== Insert %s Students..", count));
    	return string.apply(studentService.insertMany(Integer.parseInt(count)));
    }
    
    @GetMapping("/count")
    public String count(){
    	logger.info("=========== Count Students..");
    	return string.apply(studentService.count());
    }
    
    @GetMapping("/find-by-gender")
    public List<Student> findByGender(@PathVariable String gender){
    	logger.info("=========== Find By %s..", gender);
    	return studentService.selectByGender(gender);
    }

    @GetMapping("/{userid}")
    public Student profile(@PathVariable String userid){
        logger.info("프로필 정보: "+userid);
        return studentMapper.selectById(userid);
    }
    
    
    
    @GetMapping("")
    public List<?> list(){
    	logger.info("=========== Students List Execute..");
        return studentService.selectAll();
    }
    
    @PutMapping("")
    public Messenger update(@RequestBody Student student){
    	logger.info("=========== Students Updated Execute..");
        return (studentMapper.update(student) == 1) ? Messenger.SUCCESS : Messenger.FAILURE;
    }
    @DeleteMapping("")
    public Messenger delete(@RequestBody Student student){
    	logger.info("=========== Students Deleted Execute..");
        return (studentMapper.delete(student) == 1) ? Messenger.SUCCESS : Messenger.FAILURE;
    }
}