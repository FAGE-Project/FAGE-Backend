// package com.example.fage.controller;

// import com.example.fage.dto.LoginDto;
// import com.example.fage.entity.Pessoa;
// import com.example.fage.service.LoginService;
// import com.example.fage.service.TokenService;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;
// import org.springframework.web.context.WebApplicationContext;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @WebMvcTest(LoginController.class)
// public class LoginControllerTests {

//   /*  @MockBean
//     private LoginService loginService;

//     @MockBean
//     private TokenService tokenService;

//     @Autowired
//     private WebApplicationContext webApplicationContext;

//     private MockMvc mockMvc;
//     private ObjectMapper objectMapper = new ObjectMapper();

//     @BeforeEach
//     public void setup() {
//         mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//     }

//     @Test
//     public void deve_retornar_token() throws Exception {
//         LoginDto loginDto = new LoginDto();
//         loginDto.setDocumento("165.145.120-62");
//         loginDto.setPassword("AlanSenhaForteCaractereEspecialENumero");

//         Pessoa mockPessoa = new Pessoa();
//         mockPessoa.setId(1L);
//         mockPessoa.setDocumento(loginDto.getDocumento());
//         mockPessoa.setPassword(loginDto.getPassword());

//         when(loginService.verifyLogin(any(LoginDto.class))).thenReturn("Aqui será retornado um Token");

//         mockMvc.perform(post("/login")
//                         .content(objectMapper.writeValueAsString(loginDto))
//                         .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk());
//     }*/
// }
