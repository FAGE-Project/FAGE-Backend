package com.example.fage.service;

import com.example.fage.Exceptions.DocumentAlreadySignedException;
import com.example.fage.Exceptions.EmailAlreadySignedException;
import com.example.fage.Exceptions.PasswordEncondingException;
import com.example.fage.dto.PessoaDto;
import com.example.fage.entity.Pessoa;
import com.example.fage.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    Pessoa pessoa = new Pessoa();

    public PessoaDto cadastrar(PessoaDto pessoaDto) throws Exception{

        BeanUtils.copyProperties(pessoaDto, pessoa);

        criptografarSenha(pessoaDto.getPassword(), pessoa);

        validarPessoa(pessoaDto);

        pessoaRepository.save(pessoa);

        return pessoaDto;
    }

    private void criptografarSenha(String password, Pessoa pessoa) throws Exception{
        try{
            pessoa.setPassword(passwordEncoder.encode(password));
        }catch (Exception e){
            throw new PasswordEncondingException("Erro ao criptografar senha");
        }
    }

    private void validarPessoa(PessoaDto pessoaDto) throws Exception{

        List<Pessoa> verificaDocumentoRepetido = buscarPorDocumento(pessoaDto.getDocumento());

        if(!verificaDocumentoRepetido.isEmpty())
            throw new DocumentAlreadySignedException("Documento já cadastrado");

        List<Pessoa> verificaEmailRepetido = buscarPorEmail(pessoaDto.getEmail());

        if(!verificaEmailRepetido.isEmpty())
            throw new EmailAlreadySignedException("Email já cadastrado");
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
