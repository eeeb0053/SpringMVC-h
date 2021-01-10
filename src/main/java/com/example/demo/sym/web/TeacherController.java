package com.example.demo.sym.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.sym.service.Manager;
import com.example.demo.sym.service.Teacher;
import com.example.demo.sym.service.TeacherMapper;
import com.example.demo.sym.service.TeacherService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController @RequestMapping("/teachers")
public class TeacherController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired TeacherService teacherService;
    @Autowired TeacherMapper teacherMapper;
    @PostMapping("")
    public Messenger register(@RequestBody Teacher teacher){
        logger.info("등록하려는 강사 정보: "+teacher.toString());
        return (teacherService.register(teacher) == 1) ? Messenger.SUCCESS : Messenger.FAILURE;
    }
    @PostMapping("/access")
    public Teacher login(@RequestBody Teacher teacher) {
    	System.out.println("============= TEA ACCESS ============");
    	return teacherMapper.access(teacher);
    }   
    
    
    @GetMapping("/{teaNum}")
    public Teacher profile(@PathVariable String teaNum){
        return teacherService.detail(teaNum);
    }
    @GetMapping("")
    public List<?> list(){
        return teacherService.list();
    }
    @PutMapping("")
    public Messenger update(@RequestBody Teacher teacher){
        logger.info("강사 정보 수정 요청 진입: "+teacher.toString());
        return (teacherService.update(teacher) == 1) ? Messenger.SUCCESS : Messenger.FAILURE;
    }
    @DeleteMapping("")
    public Messenger delete(@RequestBody Teacher teacher){
        // logger.info("강사 정보 삭제 요청 진입: "+teacher.getTeaNum());
        return(teacherService.delete(teacher) == 1) ? Messenger.SUCCESS : Messenger.FAILURE;
    }
}
