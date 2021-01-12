package com.example.demo.sts.service;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface GradeMapper {
   public int insertMany(List<Grade> list);
   public List<GradeVo> selectJoinAll();
   public void insert(Grade grade);
   public List<Grade> selectSome(Grade grade);
   public Grade selectOne(Grade grade);
   public void update(Grade grade);
   public void delete(Grade grade);
}