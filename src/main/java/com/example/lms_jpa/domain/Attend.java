package com.example.lms_jpa.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

public class Attend {
    @Id
    @GeneratedValue
    @Column(name = "attend_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private Date enter_datetime;

    private Date left_dateTime;

    @Enumerated(EnumType.STRING)
    private AttendStatus attendStatus;


}
