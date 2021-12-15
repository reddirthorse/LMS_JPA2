package com.example.lms_jpa.service;

import com.example.lms_jpa.repository.AttendRepository;
import com.example.lms_jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AttendService {
    private final AttendRepository attendRepository;
    private final MemberRepository memberRepository;

    //입실기능 + 행 생성
    public String Enter(){
        return "입실하셨습니다.";
    }
    //퇴실기능 + 출석판별 기능 행 마무리
    public String
    //수정, 삭제 기능

    //
}
