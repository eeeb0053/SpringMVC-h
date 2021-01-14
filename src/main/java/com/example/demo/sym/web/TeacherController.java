package com.example.demo.sym.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.cmm.utl.Util.*;
import static java.util.stream.Collectors.*;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.utl.Box;
import com.example.demo.cmm.utl.Pagination;
import com.example.demo.sts.service.GradeVo;
import com.example.demo.sts.service.SubjectMapper;
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
    @Autowired SubjectMapper subjectMapper;
    @Autowired Box<Object> box;
    
    @PostMapping("")
    public Messenger register(@RequestBody Teacher teacher) {
        logger.info("등록하려는 관리자 정보: "+teacher.toString());
        return (teacherService.register(teacher) == 1) ? Messenger.SUCCESS : Messenger.FAILURE;
    }
    @PostMapping("/access")
    public Teacher login(@RequestBody Teacher teacher) {
    	System.out.println("============= TEA ACCESS ============");
    	return teacherMapper.access(teacher);
    }
    @GetMapping("/select/all/{subNum}/{examDate}")
    public Map<?, ?> selectAll(@PathVariable String subNum, @PathVariable String examDate){
    	var map = new HashMap<String, String>();
    	map.put("", examDate);
    	map.put("", subNum);
    	teacherMapper.selectAll(map);
    	map.clear();
    	return map;
    }
    
    @GetMapping("/page/{pageSize}/{pageNum}/subject/{subNum}/{examDate}")
    public Map<?, ?> selectAllBySubject(@PathVariable String pageSize, 
			@PathVariable String pageNum, @PathVariable String subNum, @PathVariable String examDate){
    	logger.info("*************** 교강사 담당 과목 시험 결과");
    	var map = new HashMap<String, Object>();
    	map.put("examDate", examDate);
    	map.put("subNum", subNum);
    	List<GradeVo> list = teacherMapper.selectAll(map);
    	System.out.println("목록 사이즈: "+list.size());
    	map.clear();
    	
    	IntSummaryStatistics is = list.stream().collect(summarizingInt(GradeVo::getScore)); // p.204
    	map.put("max", is.getMax());
    	map.put("min", is.getMin());
    	map.put("sum", is.getSum());
    	map.put("avg", is.getAverage());
    	map.put("count", is.getCount());
    	
    	System.out.println(is);
    	
    	//POJO로 구현하는 Pagination
    	
    	map.put("list", list.stream()
        		.skip(mySkip.apply(pageNum, pageSize))
        		.limit(integer.apply(pageSize))
        		.collect(toList()));
    	map.put("page", new Pagination(integer.apply(pageSize), integer.apply(pageNum), list.size()));
    	
    	map.put("subjects", subjectMapper.selectAllSubject()
    							.stream()
    							.collect(joining(",")));
    	
    	Optional<GradeVo> highScoreGrade = list.stream()
    										.collect(reducing( (g1, g2) -> g1.getScore() > g2.getScore() ? g1 : g2));
    	
        return map;
    }
}
