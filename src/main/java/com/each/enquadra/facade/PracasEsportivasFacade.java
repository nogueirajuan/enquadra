/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.facade;

import com.each.enquadra.service.bd.amazon.entities.PracaEsportiva;
import com.each.enquadra.service.bd.amazon.repositories.PracaEsportivaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author juan_
 */
@Component
public class PracasEsportivasFacade {
    
    @Autowired
    PracaEsportivaRepository pracaEsportivaRepository;
    
    public PracaEsportiva buscarPracaPorId(Integer id){
        return pracaEsportivaRepository.findOne(id);
    }
    
    public List<PracaEsportiva> buscaPracaPorNome(String nome){
        return pracaEsportivaRepository.findByLikeNome(nome);
    }
}
