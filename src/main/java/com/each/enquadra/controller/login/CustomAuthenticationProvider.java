/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.controller.login;

import com.each.enquadra.config.Properties;
import com.each.enquadra.service.bd.amazon.entities.Aluno;
import com.each.enquadra.service.bd.amazon.entities.User;
import com.each.enquadra.service.bd.amazon.repositories.AlunoRepository;
import com.each.enquadra.service.bd.amazon.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 *
 * @author victorluni
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final String LOG_PREFIX = "[CUSTOM-AUTHENTICATION-PROVIDER]";

    private static final Logger log = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Autowired
    Properties properties;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    @Autowired
    private HttpSession httpSession;

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {

        String user = a.getName();
        String pass = a.getCredentials().toString();

        log.info(LOG_PREFIX + "[USERNAME]-[{}]", user);

        if (user == null || pass == null || pass.equals("")) {
            throw new BadCredentialsException("invalid login or password");
        }

        User userLogin = userRepository.findByRgAndSenha(Integer.parseInt(user), pass);



        if (userLogin != null) {

            if(userLogin.getEAluno() == 1){
                Aluno aluno = alunoRepository.findByUser(userLogin);

                if(aluno != null) {
                    httpSession.setAttribute("aluno", aluno);
                }
                else{
                    throw new BadCredentialsException("Você não faz parte de nenhum time");
                }
            }

            List<GrantedAuthority> granted = new ArrayList<>();
            granted.add(new SimpleGrantedAuthority("1"));

            httpSession.setAttribute("userlogged", userLogin);

            return new UsernamePasswordAuthenticationToken(user, pass, granted);
        } else {
            log.error(LOG_PREFIX + "[MESSAGE]-[{}]", "Fail in authentication");
            throw new BadCredentialsException("Fail in authentication");
        }

    }

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }
}
