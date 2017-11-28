/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.controller.dashboard;

import com.each.enquadra.facade.*;
import com.each.enquadra.service.bd.amazon.entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

import com.each.enquadra.service.bd.amazon.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author juan_
 */
@RequestMapping("/dashboard")
@Controller
public class DashBoardController {

    private static final Logger log = Logger.getLogger(DashBoardController.class.getName());

    @Autowired
    private HttpSession httpSession;

    @Autowired
    TimesFacade timesFacade;

    @Autowired
    ModalidadesFacade modalidadesFacade;

    @Autowired
    UserFacade userFacade;

    @Autowired
    PracasEsportivasFacade pracasEsportivasFacade;
    
    @Autowired
    ReservasFacade reservasFacade;

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    AlunoFacade alunoFacade;

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("dashboard/index");
        List<Time> times = timesFacade.timesPorAtletica(((Aluno) httpSession.getAttribute("aluno")).getTime().getAtleticaIdatletica());
        log.info("times encontrados: " + times.size());
        mav.addObject("times", times);
        return mav;
    }

    /**
     * Reservas
     */
    @RequestMapping("/reservas")
    public ModelAndView reservas(@RequestParam(value = "praca", required = true) Integer praca) {
        ModelAndView mav = new ModelAndView("dashboard/reservas/reservas");
        List<Time> times = timesFacade.timesPorAtletica(((Aluno) httpSession.getAttribute("aluno")).getTime().getAtleticaIdatletica());
        mav.addObject("times", times);
        
        PracaEsportiva pracaAtual = pracasEsportivasFacade.buscarPracaPorId(praca);
        mav.addObject("reservas", pracaAtual.getReservaList());
        mav.addObject("praca", pracaAtual);
        return mav;
    }

    @RequestMapping(value = "/reservarPraca", method = RequestMethod.POST)
    public ModelAndView reservaPraca(@RequestParam Integer idTime, @RequestParam Integer idPraca, @RequestParam String inicio, @RequestParam String fim, @RequestParam String motivo) throws ParseException {
        ModelAndView mav = new ModelAndView("redirect:/dashboard/detalhes-time?id=" + idTime);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        
        Reserva reserva = new Reserva();
        reserva.setData(formatter.parse(inicio.replace("T", " ")));
        reserva.setDataFim(formatter.parse(fim.replace("T", " ")));
        reserva.setPracaesportivapracaesportivaId(new PracaEsportiva(idPraca));
        reserva.setTimeIdtime(new Time(idTime));
        reserva.setMotivo(motivo);
        
        if(checaConflitos(reserva)) {
            log.info("conflitou");
            ModelAndView mavError = new ModelAndView("redirect:/dashboard/reservas?alert=error&praca=" + idPraca);
            return mavError;
        }
        
        reservasFacade.criarReserva(reserva);
        
        return mav;
    }
    
    private Boolean checaConflitos(Reserva reserva){
        
        PracaEsportiva praca = pracasEsportivasFacade.buscarPracaPorId(reserva.getPracaesportivapracaesportivaId().getPracaesportivaId());
        List<Reserva> reservasPraca = praca.getReservaList();
        
        for(Reserva item : reservasPraca){

            if (reserva.getData().before(item.getDataFim()) && item.getData().before(reserva.getDataFim())) {
                return true;
            }
        }
        
        return false;
    }

    @RequestMapping("/cadastrar-reserva")
    public ModelAndView cadastrarReserva() {
        ModelAndView mav = new ModelAndView("dashboard/reservas/cadastrar-reserva");
        return mav;
    }

    @RequestMapping("/reserva")
    public ModelAndView detalhesReserva(@RequestParam String id) {
        ModelAndView mav = new ModelAndView("dashboard/reservas/detalhes-reserva");

        //detalhes da praca
        return mav;
    }

    /**
     * Atleticas
     */
    @RequestMapping("/atleticas")
    public String atleticas() {
        return "dashboard/atleticas/atleticas";
    }

    @RequestMapping("/cadastrar-atletica")
    public ModelAndView cadastrarAtletica() {
        ModelAndView mav = new ModelAndView("dashboard/atleticas/cadastrar-atletica");
        return mav;
    }

    @RequestMapping("/atletica")
    public ModelAndView detalhesAtleticas(@RequestParam String id) {
        ModelAndView mav = new ModelAndView("dashboard/atleticas/detalhes-atletica");

        //detalhes da praca
        return mav;
    }

    /**
     * Pracas
     */
    @RequestMapping("/pracas")
    public String pracas() {
        return "dashboard/pracas/pracas";
    }

    @RequestMapping("/cadastrar-praca")
    public ModelAndView cadastrarPracas() {
        ModelAndView mav = new ModelAndView("dashboard/pracas/cadastrar-praca");
        return mav;
    }

    @RequestMapping("/praca")
    public ModelAndView detalhesPracas(@RequestParam String id) {
        ModelAndView mav = new ModelAndView("dashboard/pracas/detalhes-praca");

        //detalhes da praca
        return mav;
    }

    /**
     * Times
     */
    @RequestMapping("/times")
    public ModelAndView times() {
        ModelAndView mav = new ModelAndView("dashboard/times/times");
        List<Time> times = timesFacade.timesPorAtletica(((Aluno) httpSession.getAttribute("aluno")).getTime().getAtleticaIdatletica());
        log.info("times encontrados: " + times.size());
        mav.addObject("times", times);
        //detalhes do time
        return mav;
    }

    @RequestMapping("/cadastrar-time")
    public ModelAndView cadastrarTime() {
        ModelAndView mav = new ModelAndView("dashboard/times/cadastrar-time");
        List<Modalidades> modalidades = modalidadesFacade.getModalidades();
        mav.addObject("modalidades", modalidades);
        return mav;
    }

    @RequestMapping(value = "/cadastrar-time-action", method = RequestMethod.POST)
    public ModelAndView cadastrarTimeAction(@RequestParam String nome, @RequestParam Integer modalidadeId, @RequestParam String genero) {
        ModelAndView mav = new ModelAndView("redirect:/dashboard/times");

        log.log(Level.INFO, "start - create team");

        Aluno onlineUser = (Aluno) httpSession.getAttribute("aluno");

        Time novoTime = new Time();
        novoTime.setGenero(genero);
        novoTime.setNome(nome);
        novoTime.setAtleticaIdatletica(onlineUser.getTime().getAtleticaIdatletica());
        novoTime.setModalidadesModalidadesId(new Modalidades(modalidadeId));
        timesFacade.criarTime(novoTime);

        return mav;
    }

    @RequestMapping(value = "/remover-time-action", method = RequestMethod.GET)
    public ModelAndView removerTimeAction(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("redirect:/dashboard/times");

        log.log(Level.INFO, "start - delete team");

        timesFacade.deletarTime(id);

        return mav;
    }
    
    @RequestMapping(value = "/remover-reserva-action", method = RequestMethod.GET)
    public ModelAndView removerReservaAction(@RequestParam Integer id, @RequestParam Integer idTime) {
        ModelAndView mav = new ModelAndView("redirect:/dashboard/detalhes-time?id=" + idTime);

        log.log(Level.INFO, "start - delete reserva");

        reservasFacade.excluirReserva(id);

        return mav;
    }

    @RequestMapping("/detalhes-time")
    public ModelAndView detalhesTime(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("dashboard/times/detalhes-time");
//        List<Time> times = timesFacade.timesPorAtletica(((Aluno) httpSession.getAttribute("aluno")).getTime().getAtleticaIdatletica());

        Time time = timesFacade.timePorId(id);
        List<User> alunos = userFacade.findAllAlunos();
        List<User> tecnicos = userFacade.findAllCoachs();


        mav.addObject("time", time);
        mav.addObject("alunos", alunos);
        mav.addObject("tecnicos", alunos);

        //detalhes do time
        return mav;
    }

    @RequestMapping("/incluir-aluno-time")
    public ModelAndView incluirAlunotime(@RequestParam Integer rg, @RequestParam Integer idTime) {
        ModelAndView mav = new ModelAndView("redirect:/dashboard/detalhes-time?id=" + idTime);

        alunoFacade.atualizaTime(rg, idTime);

        //detalhes do time
        return mav;
    }

    @RequestMapping("/remover-aluno-time")
    public ModelAndView removerAlunotime(@RequestParam Integer rg, @RequestParam Integer idTime) {
        ModelAndView mav = new ModelAndView("redirect:/dashboard/detalhes-time?id=" + idTime);

        alunoFacade.removeTime(rg);

        //detalhes do time
        return mav;
    }

    @RequestMapping("/atualiza-tecnico-time")
    public ModelAndView atualizaTecnicotime(@RequestParam Integer rgTecnico, @RequestParam Integer idTime) {
        ModelAndView mav = new ModelAndView("redirect:/dashboard/detalhes-time?id=" + idTime);

        userFacade.atualizaTecnicoTime(rgTecnico, idTime);

        //detalhes do time
        return mav;
    }

    @RequestMapping("/atualiza-dm-time")
    public ModelAndView atualizaDmtime(@RequestParam Integer rgDm, @RequestParam Integer idTime) {
        ModelAndView mav = new ModelAndView("redirect:/dashboard/detalhes-time?id=" + idTime);

        userFacade.atualizaDmTime(rgDm, idTime);

        //detalhes do time
        return mav;
    }

    @RequestMapping("/criar-tecnico")
    public ModelAndView criarTecnico(@RequestParam Integer idTime, @RequestParam String name, @RequestParam Integer rg, @RequestParam String telefone, @RequestParam String celular
    ) {
        ModelAndView mav = new ModelAndView("redirec:/dashboard/detalhes-time?id=" + idTime);
        Time time = timesFacade.timePorId(idTime);

//        TelefoneUser telefoneObj = new TelefoneUser(telefone, rg);
//        TelefoneUser celularObj = new TelefoneUser(celular, rg);
//        List<TelefoneUser> telefones = new ArrayList<>();
//        
//        telefones.add(telefoneObj);
//        telefones.add(celularObj);
        User novoTecnico = new User();
        novoTecnico.setETecnico(Short.valueOf("1"));
        novoTecnico.setNome(name);
        novoTecnico.setRg(rg);
//        novoTecnico.setTelefoneUserList(telefones);
        novoTecnico = userFacade.createUser(novoTecnico);

        Tecnico tecnicoInfo = new Tecnico(rg, time.getIdtime());
        tecnicoInfo.setUser(novoTecnico);
        log.info("tecnicoInfo: " + tecnicoInfo);
        tecnicoInfo = userFacade.createTecnico(tecnicoInfo);

        List<Tecnico> tecnicoTime = new ArrayList<>();
        tecnicoTime.add(tecnicoInfo);

//        novoTecnico.setTecnicoList(tecnicoTime);
        log.info("novoTecnico: " + novoTecnico);
        userFacade.createUser(novoTecnico);
        time.setTecnicoList(tecnicoTime);

        log.info("time: " + time);
        timesFacade.criarTime(time);

        //detalhes do time
        return mav;
    }

    @RequestMapping("/criar-dm")
    public ModelAndView criarDm(@RequestParam Integer idTime, @RequestParam String name, @RequestParam Integer rg, @RequestParam String telefone, @RequestParam String celular
    ) {
        ModelAndView mav = new ModelAndView("redirec:/dashboard/detalhes-time?id=" + idTime);
        Time time = timesFacade.timePorId(idTime);

        TelefoneUser telefoneObj = new TelefoneUser(telefone, rg);
        TelefoneUser celularObj = new TelefoneUser(celular, rg);
        List<TelefoneUser> telefones = new ArrayList<>();

        telefones.add(telefoneObj);
        telefones.add(celularObj);

        User novoDm = new User();
        novoDm.setETecnico(Short.valueOf("0"));
        novoDm.setNome(name);
        novoDm.setRg(rg);
        novoDm.setTelefoneUserList(telefones);

        DiretorModalidade dmInfo = new DiretorModalidade(rg, time.getIdtime());
        List<DiretorModalidade> dmTime = new ArrayList<>();
        dmTime.add(dmInfo);

        novoDm.setDiretorModalidadeList(dmTime);

        userFacade.createUser(novoDm);
        time.setDiretorModalidadeList(dmTime);
        timesFacade.criarTime(time);

        //detalhes do time
        return mav;
    }

    @RequestMapping("/criar-aluno")
    public ModelAndView criarAluno(@RequestParam Integer idTime, @RequestParam String name, @RequestParam Integer rg, @RequestParam String telefone, @RequestParam String celular
    ) {
        ModelAndView mav = new ModelAndView("redirec:/dashboard/detalhes-time?id=" + idTime);
        Time time = timesFacade.timePorId(idTime);

        TelefoneUser telefoneObj = new TelefoneUser(telefone, rg);
        TelefoneUser celularObj = new TelefoneUser(celular, rg);
        List<TelefoneUser> telefones = new ArrayList<>();

        telefones.add(telefoneObj);
        telefones.add(celularObj);

        User novoAlunoo = new User();
        novoAlunoo.setETecnico(Short.valueOf("0"));
        novoAlunoo.setNome(name);
        novoAlunoo.setRg(rg);
        novoAlunoo.setTelefoneUserList(telefones);

        Aluno aluno = new Aluno(rg, time.getIdtime());
        List<Aluno> alunosTimeList = new ArrayList<>();
        alunosTimeList.add(aluno);

        userFacade.createUser(novoAlunoo);
        time.setAlunoList(alunosTimeList);
        timesFacade.criarTime(time);

        //detalhes do time
        return mav;
    }

    @RequestMapping("/escolher-praca")
    public ModelAndView escolherPraca(@RequestParam(name = "q", required = false, defaultValue = "") String search) {
        ModelAndView mav = new ModelAndView("dashboard/pracas/pracas");

        if (!search.isEmpty()) {
            log.info("Search nao eh nulo");
            List<PracaEsportiva> pracas = pracasEsportivasFacade.buscaPracaPorNome(search);
            log.info("pracas: " + pracas.size());
            mav.addObject("pracas", pracas);
        }
        return mav;
    }

}
