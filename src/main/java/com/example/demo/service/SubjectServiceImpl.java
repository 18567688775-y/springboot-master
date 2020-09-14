package com.example.demo.service;

import com.example.demo.entity.Subject;
import com.example.demo.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

  @Autowired
  private SubjectMapper subjectMapper;

  @Override
  public List<Subject> getSubjectName(String subjectName) {
    return subjectMapper.getSubjectName(subjectName);
  }

  @Override
  public Subject getSubName(String subName) {
    return subjectMapper.getSubName(subName);
  }

  @Override
  public List<Subject> getSubAll() {
    return subjectMapper.getSubAll();
  }
}
