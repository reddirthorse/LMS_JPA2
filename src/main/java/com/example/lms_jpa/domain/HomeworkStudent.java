package com.example.lms_jpa.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HomeworkStudent {
    @Id
    @GeneratedValue
    @Column(name = "homework_student_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "homework_teacher_id")
    private HomeworkTeacher homeworkTeacher;
    //private homeworkfile

    private Date registDatatime;
}
