package com.example.demo.controller;


import com.example.demo.entity.Subject;
import com.example.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.redis.RedisUtil;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SubjectController {

  @Autowired
  private SubjectService subjectService;

  @Autowired
  private RedisUtil redisUtil;

  @RequestMapping(value = "/getSub")
  public List<Subject> getSubjectName(@RequestParam String subjectName){
    List list = subjectService.getSubjectName(subjectName);
    return list;
  }

  @RequestMapping(value = "/getSubAll")
  public List<Subject> getSubAll(){
    List<Subject> list = subjectService.getSubAll();
//    redisUtil.lSet("list",list);
//    List list2 = redisUtil.lGet("list",0,-1);
//    for(Subject s: list){
//      System.out.println(s.getSubjectName());
//    }
    return list;
  }


  @RequestMapping(value = "/getSubName")
  public Subject getSubName(@RequestParam String subName){
    Subject sub = subjectService.getSubName(subName);
    //存放缓存
//    redisUtil.set("sub",sub);

    boolean s = redisUtil.hasKey("sub");
    System.out.println(s);
    return sub;
  }

}
