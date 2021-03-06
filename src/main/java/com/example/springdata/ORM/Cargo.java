package com.example.springdata.ORM;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Cargo 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String funcao;
    @OneToMany (mappedBy = "cargo")
    private List<Funcionario> funcionario;

    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public String getFuncao()
    {
        return funcao;
    }
    public void setFuncao(String funcao)
    {
        this.funcao = funcao;
    }
    @Override
    public String toString()
    {
        return "id =" + id + ", funcao = " + funcao;
    }
}
