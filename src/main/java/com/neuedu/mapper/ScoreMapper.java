package com.neuedu.mapper;

import com.neuedu.po.Course;
import com.neuedu.po.Student;

public interface ScoreMapper {

    public Student getStudentScores(int sid);

    public Course getCourseScores(int cid);
}
