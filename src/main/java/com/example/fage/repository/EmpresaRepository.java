package com.example.fage.repository;

import com.example.fage.entity.Empresa;
import com.example.fage.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    List<Empresa> findByNomeContainingIgnoreCase(String nome);

//    @Query("SELECT f.id from empresa_funcionarios ef inner join funcionario f on f.id = ef.funcionario_id where ef.id = ?1")
//    List<Funcionario> buscarFuncionariosDaEmpresa(Long id);

    Optional<Empresa> findById(Long id);
    
}
