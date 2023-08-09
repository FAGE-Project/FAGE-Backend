package com.example.fage.controller;

import com.example.fage.dto.LoginDto;
import com.example.fage.entity.Pessoa;
import com.example.fage.service.LoginService;
import com.example.fage.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    TokenService tokenService;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping()
    public ResponseEntity login(@RequestBody LoginDto loginDto){

        try{
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(loginDto.getDocumento(),
                            loginDto.getPassword());

            Authentication authenticate = this.authenticationManager
                    .authenticate(usernamePasswordAuthenticationToken);

            var pessoa = (Pessoa) authenticate.getPrincipal();

            if(pessoa != null){
                return ResponseEntity
                        .ok(tokenService.generateToken(pessoa));
            }

        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Usuário Não Encontrado");
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

}
