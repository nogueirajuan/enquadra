/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.service.bd.amazon.repositories;

import com.each.enquadra.service.bd.amazon.entities.Aluno;
import com.each.enquadra.service.bd.amazon.entities.Time;
import com.each.enquadra.service.bd.amazon.entities.User;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author juan_
 */
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {

    @Override
    List<Aluno> findAll();

    Aluno findByNroUsp(Integer nroUsp);

    Aluno findByUser(User user);
    
    Aluno findByUserRg(Integer rg);

    List<Aluno> findByTime(Time time);
}
