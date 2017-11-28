/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.service.bd.amazon.repositories;

import com.each.enquadra.service.bd.amazon.entities.Atletica;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author juan_
 */
public interface AtleticaRepository extends CrudRepository<Atletica, Integer> {

    @Override
    List<Atletica> findAll();
    
    @Override
    Atletica findOne(Integer idAtletica);
    
    Atletica findByPresidente(String presidente);
    
    List<Atletica> findByFaculdade(String faculdade);
}
