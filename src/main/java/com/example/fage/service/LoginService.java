package com.example.fage.service;

import com.example.fage.dto.LoginDto;
import com.example.fage.entity.Pessoa;
import com.example.fage.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {
    @Autowired
    PessoaRepository pessoaRepository;
    public String verifyLogin(LoginDto loginDto) {
        try {
            Optional<Pessoa> person = pessoaRepository.findByDocumentoAndPassword(loginDto.getDocumento(), loginDto.getPassword());
            if(person.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
            }
            return "Aqui será retornado um Token";
        } catch (ResponseStatusException exception){
            throw new ResponseStatusException(exception.getStatusCode(), exception.getReason());
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return pessoaRepository.findByDocumento(username).get();
    }
}
