package com.example.lms_jpa.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Member {
    @Id
    @Column(name = "member_id")
    private String id;
    @Column(name = "member_name")
    private String name;
}
