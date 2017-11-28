/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.facade;

import com.each.enquadra.service.bd.amazon.entities.Aluno;
import com.each.enquadra.service.bd.amazon.entities.DiretorModalidade;
import com.each.enquadra.service.bd.amazon.entities.Tecnico;
import com.each.enquadra.service.bd.amazon.entities.User;
import com.each.enquadra.service.bd.amazon.repositories.AlunoRepository;
import com.each.enquadra.service.bd.amazon.repositories.DmRepository;
import com.each.enquadra.service.bd.amazon.repositories.TecnicoRepository;
import com.each.enquadra.service.bd.amazon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author juan_
 */
@Component
public class UserFacade {

    protected EntityManager em;

    public UserFacade(EntityManager em) {
        this.em = em;
    }
    
    @Autowired
    UserRepository userRepository;   
    
    @Autowired
    AlunoRepository alunoRepository;
    
    @Autowired
    TecnicoRepository tecnicoRepository;
    
    @Autowired
    DmRepository dmRepository;
    
    public User createUser(User user){
        return userRepository.save(user);
    }
    
    public void remoteUser(Integer idUser){
        userRepository.delete(idUser);
    }
    
    public void updateUser(User user){
        userRepository.save(user);
    }
    
    public User findUserById(Integer idUser){
        return userRepository.findOne(idUser);
    }
    
    public User findUserByRg(Integer rg){
        return userRepository.findOne(rg);
    }

    public List<User> findAllCoachs() {return userRepository.findAllByETecnico(Short.valueOf("1"));};

    public List<User> findAllAlunos() {return userRepository.findAllByEAluno(Short.valueOf("1"));};
    
    public Tecnico createTecnico(Tecnico novoTecnico){
        return tecnicoRepository.save(novoTecnico);
    }
    
    public Aluno createAluno(Aluno novoAluno){
        return alunoRepository.save(novoAluno);
    }
    
    public DiretorModalidade createDm(DiretorModalidade novoDiretorModalidade){
        return dmRepository.save(novoDiretorModalidade);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Throwable.class)
    public void atualizaTecnicoTime(Integer rgTecnico, Integer idTime) {

        Query check = em.createQuery("select count(e) from Tecnico e where e.user.rg = ? and e.time.idtime = ?");
        check.setParameter(1, rgTecnico);
        check.setParameter(2, idTime);

        long num = ((Number)check.getSingleResult()).longValue();

        if(num > 0){
            Query query = em.createNativeQuery("update tecnico set user_rg = ? where time_idtime = ?");
            query.setParameter(1, rgTecnico);
            query.setParameter(2, idTime);
            query.executeUpdate();
        }else{
            Query query = em.createNativeQuery("INSERT INTO tecnico (data_gestao, user_rg, time_idtime) VALUES (NOW(), ?, ?)");
            query.setParameter(1, rgTecnico);
            query.setParameter(2, idTime);
            query.executeUpdate();
        }


    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Throwable.class)
    public void atualizaDmTime(Integer rg, Integer idTime) {

        Query check = em.createQuery("select count(e) from DiretorModalidade e where e.user.rg = ? and e.time.idtime = ?");
        check.setParameter(1, rg);
        check.setParameter(2, idTime);

        long num = ((Number)check.getSingleResult()).longValue();

        if(num > 0){
            Query query = em.createNativeQuery("update diretor_modalidade set user_rg = ? where time_idtime = ?");
            query.setParameter(1, rg);
            query.setParameter(2, idTime);
            query.executeUpdate();
        }else{
            Query query = em.createNativeQuery("INSERT INTO diretor_modalidade (ano_mandato, user_rg, time_idtime) VALUES (2017, ?, ?)");
            query.setParameter(1, rg);
            query.setParameter(2, idTime);
            query.executeUpdate();
        }


    }

}
