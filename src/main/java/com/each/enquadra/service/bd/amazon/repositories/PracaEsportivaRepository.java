/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.service.bd.amazon.repositories;

import com.each.enquadra.service.bd.amazon.entities.Local;
import com.each.enquadra.service.bd.amazon.entities.PracaEsportiva;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author juan_
 */
public interface PracaEsportivaRepository extends CrudRepository<PracaEsportiva, Integer> {

    @Override
    List<PracaEsportiva> findAll();
    
    @Override
    PracaEsportiva findOne(Integer pracaesportivaId);
    
    PracaEsportiva findByNome(String nome);
    
    @Query("SELECT p FROM PracaEsportiva p WHERE p.nome LIKE CONCAT('%',?1,'%') ")
    List<PracaEsportiva> findByLikeNome(String nome);
    
    List<PracaEsportiva> findByLocalIdlocal(Local local);
}
