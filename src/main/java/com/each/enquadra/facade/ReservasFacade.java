/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.facade;

import com.each.enquadra.service.bd.amazon.entities.Reserva;
import com.each.enquadra.service.bd.amazon.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author juan_
 */
@Component
public class ReservasFacade {
    @Autowired
    ReservaRepository reservaRepository;
    
    public Reserva criarReserva(Reserva reserva){
        return reservaRepository.save(reserva);
    }
    
    public void excluirReserva(Integer id){
        reservaRepository.delete(id);
    }
}
