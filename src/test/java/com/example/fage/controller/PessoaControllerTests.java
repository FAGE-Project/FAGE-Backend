// package com.example.fage.controller;

// import com.auth0.net.CreateUserRequest;
// import com.example.fage.dto.EmpresaDto;
// import com.example.fage.dto.PessoaDto;
// import com.example.fage.entity.Empresa;
// import com.example.fage.entity.Pessoa;
// import com.example.fage.service.EmpresaService;
// import com.example.fage.service.PessoaService;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;
// import org.springframework.web.context.WebApplicationContext;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.*;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @RunWith(SpringRunner.class)
// @WebMvcTest(PessoaController.class)

// public class PessoaControllerTests {

//     @MockBean
//     PessoaService pessoaService;
//     ObjectMapper objectMapper = new ObjectMapper();

//     @Autowired
//     private WebApplicationContext webApplicationContext;

//     @Autowired
//     MockMvc mockMvc;

//     @Before()
//     public void setup() {
//         mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//     }

//     @Test
//     public void deve_retornar_pessoa_criada() throws Exception {

//         PessoaDto pessoaDto = new PessoaDto();

//         pessoaDto.setNome("Helon B");
//         pessoaDto.setPassword("213vivaoif");
//         pessoaDto.setDocumento("059.476.540-40");
//         pessoaDto.setEmail("helonbetensr51@gmail.com");

//         when(pessoaService.cadastrar(any(PessoaDto.class))).thenReturn(pessoaDto);

//         mockMvc.perform(post("/cadastro")
//                 .content(objectMapper.writeValueAsString(pessoaDto))
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isCreated());
//     }

//     @Test
//     public void pessoa_vazia_deve_retornar_bad_request() throws Exception {

//         PessoaDto pessoaDto = new PessoaDto();

//         when(pessoaService.cadastrar(any(PessoaDto.class))).thenReturn(pessoaDto);

//         mockMvc.perform(post("/cadastro")
//                         .content(objectMapper.writeValueAsString(null))
//                         .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isBadRequest());
//     }

// }

