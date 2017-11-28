/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.service.bd.amazon.repositories;

import com.each.enquadra.service.bd.amazon.entities.PracaEsportiva;
import com.each.enquadra.service.bd.amazon.entities.Reserva;
import com.each.enquadra.service.bd.amazon.entities.Time;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author juan_
 */
public interface ReservaRepository extends CrudRepository<Reserva, Integer> {

    @Override
    List<Reserva> findAll();

    @Override
    Reserva findOne(Integer idReserva);

    List<Reserva> findByPracaesportivapracaesportivaId(PracaEsportiva pracaEsportiva);

    List<Reserva> findByTimeIdtime(Time time);

}
