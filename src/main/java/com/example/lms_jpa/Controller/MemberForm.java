package com.example.lms_jpa.Controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberForm {
    @NotEmpty(message = "회원 아이디를 입력하세요")
    private String user_id;
    @NotEmpty(message = "회원 이름을 입력하세요")
    private String name;


}
