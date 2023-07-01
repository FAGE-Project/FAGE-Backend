package com.example.fage.service;

import com.example.fage.dto.LoginDto;
import com.example.fage.dto.PessoaDto;
import com.example.fage.model.Pessoa;
import com.example.fage.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public String cadastrar(PessoaDto pessoaDto) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDto, pessoa);
        List<Pessoa> verificaEmailRepetido = buscarPorEmail(pessoaDto.getEmail());
        List<Pessoa> verificaDocumentoRepetido = buscarPorDocumento(pessoaDto.getDocumento());
        if(verificaEmailRepetido == null){
            if(verificaDocumentoRepetido == null){
                pessoaRepository.save(pessoa);
                return "Sucesso no cadastro";
            }
        }else {
             return "Email já cadastrado";
        }
        return null;
        
       

    }

    public LoginDto autenticar(LoginDto loginDto) {

        try {
            Optional<Pessoa> pessoa = pessoaRepository.findByEmailAndSenha(loginDto.getDocumento(),
                    loginDto.getSenha());

            if (pessoa.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
            }

            return loginDto;
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public List<Pessoa> listarTodos() {
        return pessoaRepository.findAll();
    }

    public PessoaDto buscarPorId(Long id) {

        try {
            Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

            if (pessoaOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma Estado foi encontrada");
            }
            PessoaDto pessoaDto = new PessoaDto();
            BeanUtils.copyProperties(pessoaOptional.get(), pessoaDto);

            return pessoaDto;

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public List<Pessoa> buscarPorNome(String nome) {

        try {
            List<Pessoa> listaPessoa = pessoaRepository.findByNomeContainingIgnoreCase(nome);

            if (listaPessoa.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma Estado foi encontrada");
            }

            return listaPessoa;

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }
    
    public List<Pessoa> buscarPorEmail(String email) {

        try {
            List<Pessoa> listaPessoa = pessoaRepository.findByEmailContainingIgnoreCase(email);

            if (listaPessoa.isEmpty()) {
                return null;
            }

            return listaPessoa;

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public List<Pessoa> buscarPorDocumento(String documento) {

        try {
            List<Pessoa> listaPessoa = pessoaRepository.findByEmailContainingIgnoreCase(documento);

            if (listaPessoa.isEmpty()) {
                return null;
            }

            return listaPessoa;

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public void atualizar(PessoaDto pessoaDto) {
        try {
            validarAtualizacaoPessoa(pessoaDto);
            Pessoa pessoa = new Pessoa();
            BeanUtils.copyProperties(pessoaDto, pessoa);
            pessoaRepository.save(pessoa);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }

    public void excluir(Long id) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoaRepository.delete(pessoa);
    }

    private void validarAtualizacaoPessoa(PessoaDto pessoaDto) throws ResponseStatusException {
        try {

            if (pessoaDto == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Informe um estado para atualizar");
            }
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getReason());
        }
    }
}
