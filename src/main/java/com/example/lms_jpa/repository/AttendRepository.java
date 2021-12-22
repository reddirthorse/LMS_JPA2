package com.example.lms_jpa.repository;

import com.example.lms_jpa.domain.Attend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AttendRepository {
    private final EntityManager em;

    public void save(Attend attend){
        em.persist(attend);
    }

    public List<Attend> findAll(){
        return em.createQuery("select a from Attend a",Attend.class)
                .getResultList();
    }
    //아이디를 통한 개인별 전체 출석 검색
    public List<Attend> findByMember(String id){
        return em.createQuery("select a from Attend a where a.member =:id",Attend.class)
                .setParameter("id",id)
                .getResultList();
    }
    //과연 어탠드서치를 쓸 이유가 있는가??
    //월별 검색 로직 1. date를 string 배열로 보고 그안에서 해당 월이 있는가 판별

}
