/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.service.bd.amazon.repositories;

import com.each.enquadra.service.bd.amazon.entities.Aluno;
import com.each.enquadra.service.bd.amazon.entities.Atletica;
import com.each.enquadra.service.bd.amazon.entities.Modalidades;
import com.each.enquadra.service.bd.amazon.entities.Time;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author juan_
 */
public interface TimeRepository extends CrudRepository<Time, Integer> {

    @Override
    List<Time> findAll();

    @Override
    Time findOne(Integer idTime);

    Time findByNome(String nome);

    Time findByModalidadesModalidadesId(Modalidades modalidades);
    
    Time findByAlunoList(List<Aluno> aluno);
    
    List<Time> findByAtleticaIdatletica(Atletica atletica);
}
