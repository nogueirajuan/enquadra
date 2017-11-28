/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.service.bd.amazon.repositories;

import com.each.enquadra.service.bd.amazon.entities.DiretorModalidade;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author juan_
 */
public interface DmRepository extends CrudRepository<DiretorModalidade, Integer> {

    @Override
    List<DiretorModalidade> findAll();
    
    @Override
    DiretorModalidade findOne(Integer idUser);
    
}
