/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.service.bd.amazon.repositories;

import com.each.enquadra.service.bd.amazon.entities.Modalidades;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author juan_
 */
public interface ModalidadeRepository extends CrudRepository<Modalidades, Integer> {

    @Override
    List<Modalidades> findAll();
    
    @Override
    Modalidades findOne(Integer idModalidade);
    
    
}
