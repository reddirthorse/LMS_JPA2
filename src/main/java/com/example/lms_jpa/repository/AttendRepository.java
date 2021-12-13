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
    public List<Attend> findByMember(String id){
        return em.createQuery("select a from Attend a where a.member =:id",Attend.class)
                .setParameter("id",id)
                .getResultList();
    }
}
