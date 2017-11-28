/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.facade;

import com.each.enquadra.service.bd.amazon.entities.Modalidades;
import com.each.enquadra.service.bd.amazon.repositories.ModalidadeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author juan_
 */
@Component
public class ModalidadesFacade {

    @Autowired
    ModalidadeRepository modalidadeRepository;

    public List<Modalidades> getModalidades() {
        return modalidadeRepository.findAll();
    }

}
