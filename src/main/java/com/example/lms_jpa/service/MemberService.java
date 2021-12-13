package com.example.lms_jpa.service;

import com.example.lms_jpa.domain.Member;
import com.example.lms_jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    //default값이 false임으로 등록기능에 추가해준다.
    public Long join(Member member){
        validateDuplicatedMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicatedMember(Member member){
        List<Member> findMembers = memberRepository.findByMember(member.getUser_id());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
    //회원 전체조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    //회원 한명 조회
    public Member findOne(Long id){
        return memberRepository.findOne(id);
    }
}
