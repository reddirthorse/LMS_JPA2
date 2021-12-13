package com.example.lms_jpa.service;

import com.example.lms_jpa.domain.Member;
import com.example.lms_jpa.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;
    @Test
    public void 회원가입() throws Exception{
        Member member = new Member();
        member.setName("서성우");
        member.setUser_id("operstu1");

        Long saveIdName = memberService.join(member);

        assertEquals(member,memberService.findOne(member.getId()));
    }
    @Test
    public void 중복확인() throws Exception{
        Member member1 = new Member();
        member1.setUser_id("operstu1");

        Member member2 = new Member();
        member2.setUser_id("operstu1");


        memberService.join(member1);
        try{
            memberService.join(member2);//예외 터져야 함
        }catch(IllegalStateException e){
            return;
        }

        fail("예외가 발생해야합니다!!");

    }
}