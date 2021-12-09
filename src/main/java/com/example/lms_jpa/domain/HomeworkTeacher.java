package com.example.lms_jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class HomeworkTeacher {
    @Id
    @GeneratedValue
    @Column(name = "homework_teacher_id")
    private Long id;

    private String subject;
    private Date startDate;
    private Date dueDate;
}
