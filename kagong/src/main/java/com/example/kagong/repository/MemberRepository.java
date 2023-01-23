package com.example.kagong.repository;

import com.example.kagong.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {
    @PersistenceContext
    EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getMemberId();
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name")
                .setParameter("name", name)
                .getResultList();
    }

    public void deleteOne(Long memberId){
        em.createQuery("delete from Member m where m.memberId = :memberId")
                .setParameter("memberId", memberId)
                .executeUpdate();
        em.clear();
    }
}
