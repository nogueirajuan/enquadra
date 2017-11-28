package com.each.enquadra.facade;

import com.each.enquadra.service.bd.amazon.entities.Atletica;
import com.each.enquadra.service.bd.amazon.repositories.AlunoRepository;
import com.each.enquadra.service.bd.amazon.repositories.AtleticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class AlunoFacade {

    @Autowired
    AlunoRepository alunoRepository;

    protected EntityManager em;

    public AlunoFacade(EntityManager em) {
        this.em = em;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Throwable.class)
    public void atualizaTime(Integer rg, Integer idTime) {

        Query check = em.createQuery("select count(e) from Aluno e where e.user.rg = ? and e.time.idtime = ?");
        check.setParameter(1, rg);
        check.setParameter(2, idTime);

        long num = ((Number)check.getSingleResult()).longValue();

        if(num > 0){
            Query query = em.createNativeQuery("UPDATE aluno SET time_idtime = ? WHERE user_rg = ?");
            query.setParameter(1, idTime);
            query.setParameter(2, rg);
            query.executeUpdate();
        }else{

            int randomNum = 1000000 + (int)(Math.random() * 8000000);

            Query query = em.createNativeQuery("INSERT INTO aluno (nro_usp, user_rg, time_idtime, anoIngresso) VALUES (?, ?, ?, 2017)");
            query.setParameter(1, randomNum);
            query.setParameter(2, rg);
            query.setParameter(3, idTime);
            query.executeUpdate();
        }


    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Throwable.class)
    public void removeTime(Integer rg) {
        Query query = em.createNativeQuery("DELETE FROM aluno WHERE user_rg = ?");
        query.setParameter(1, rg);
        query.executeUpdate();
    }

}
