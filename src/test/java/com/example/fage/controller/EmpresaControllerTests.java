package com.example.fage.controller;

import com.auth0.net.CreateUserRequest;
import com.example.fage.dto.EmpresaDto;
import com.example.fage.entity.Empresa;
import com.example.fage.service.EmpresaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmpresaController.class)

public class EmpresaControllerTests {

    @MockBean
    EmpresaService empresaService;

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    MockMvc mockMvc;

    @Before()
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void deve_retornar_empresa_criada() throws Exception {

        Empresa empresa = new Empresa();

        empresa.setNome("Fage");

        when(empresaService.cadastrar(any(EmpresaDto.class))).thenReturn(empresa);

        mockMvc.perform(post("/empresa")
                        .content(objectMapper.writeValueAsString(empresa))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
    public void empresa_vazia_deve_retornar_bad_request() throws Exception {

        Empresa empresa = new Empresa();

        when(empresaService.cadastrar(any(EmpresaDto.class))).thenReturn(empresa);

        mockMvc.perform(post("/empresa")
                        .content(objectMapper.writeValueAsString(null))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());


    }

}
