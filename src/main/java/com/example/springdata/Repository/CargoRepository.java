package com.example.springdata.Repository;

import com.example.springdata.ORM.Cargo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer>
{
    
}
