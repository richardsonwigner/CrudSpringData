package com.example.springdata.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springdata.ORM.Funcionario;

import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
    
}
