package com.example.lms_jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue
    private Long id;
    @Column(name = "member_user_id")
    private String user_id;
    @Column(name = "member_name")
    private String name;

}
