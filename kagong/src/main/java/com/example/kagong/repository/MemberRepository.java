package com.example.kagong.repository;

import com.example.kagong.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

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
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    public Member findByNameOne(String name){
        List<Member> findMembers = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name).getResultList();
        return findMembers.get(0);
    }

    public void deleteOne(Long memberId){
        em.createQuery("delete from Member m where m.memberId = :memberId")
                .setParameter("memberId", memberId)
                .executeUpdate();
        em.clear();
    }

    public List<Member> findNickName(String nickName){
        return em.createQuery("select m from Member m where m.nickName = :nickName", Member.class)
                .setParameter("nickName", nickName).getResultList();
    }

    public List<Member> findEmail(String email){
        return em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email).getResultList();
    }

}
