package com.example.demo.mapper;

import com.example.demo.entity.Subject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("subjectMapper")
public interface SubjectMapper {
  List<Subject> getSubjectName(@Param("subjectName") String subjectName);

  Subject getSubName(@Param("subName") String subName);
}
