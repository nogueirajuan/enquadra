package com.each.enquadra.facade;

import com.each.enquadra.service.bd.amazon.entities.Atletica;
import com.each.enquadra.service.bd.amazon.repositories.AtleticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AtleticaFacade {

    @Autowired
    AtleticaRepository atleticaRepository;

    public Atletica findById(Integer id) {
        return atleticaRepository.findOne(id);
    }

    public List<Atletica> findAll(){
        return atleticaRepository.findAll();
    }

}
