/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.facade;

import com.each.enquadra.service.bd.amazon.entities.Aluno;
import com.each.enquadra.service.bd.amazon.entities.Atletica;
import com.each.enquadra.service.bd.amazon.entities.Time;
import com.each.enquadra.service.bd.amazon.repositories.AlunoRepository;
import com.each.enquadra.service.bd.amazon.repositories.PracaEsportivaRepository;
import com.each.enquadra.service.bd.amazon.repositories.TimeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author juan_
 */
@Component
public class TimesFacade {
    
    
    @Autowired
    AlunoRepository alunoRepository;
    
    @Autowired
    TimeRepository timeRepository;
    
    @Autowired
    PracaEsportivaRepository pracaEsportivaRepository;
    
    public List<Time> timesPorAtletica(Atletica atletica){
        return timeRepository.findByAtleticaIdatletica(atletica);
    }
    
    public Time timePorId(Integer id){
        return timeRepository.findOne(id);
    }
    
    public Time timePorAluno(Aluno aluno){
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);
        return timeRepository.findByAlunoList(alunos);
    }
    
    public List<Time> todosTimes(){
        return timeRepository.findAll();
    }
    
    public Time timePorNome(String nome){
        return timeRepository.findByNome(nome);
    }
    
    public void criarTime(Time time){
        timeRepository.save(time);
    }
    
    public void atualizarTime(Time time){
        timeRepository.save(time);
    }
    
    public void deletarTime(Integer idTime){
        timeRepository.delete(idTime);
    }
    
}
