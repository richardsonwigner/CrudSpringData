package com.example.springdata.CrudService;

import java.util.Scanner;

import com.example.springdata.ORM.Cargo;
import com.example.springdata.Repository.CargoRepository;

import org.springframework.stereotype.Service;

@Service
public class CrudCargoService 
{
    private final CargoRepository cargoRepository;

    public CrudCargoService(CargoRepository cargoRepository)
    {
        this.cargoRepository = cargoRepository;
    }
    public void inicial(Scanner scanner)
    {
        Boolean system = true;
		while (system)
		{
			System.out.println("Opções");
			System.out.println("0 - SAIR");
			System.out.println("1 - ESCREVER FUNCAO");
			System.out.println("2 - ATUALIZAR FUNCAO");
			System.out.println("3 - DELETAR FUNCAO");
			System.out.println("4 - VISUALIZAR FUNCAO");


			int escolha = scanner.nextInt();
			if(escolha == 1)
			{
				salvar(scanner);
			}
			else if(escolha == 2)
			{
				atualizar(scanner);
			}
			else if(escolha == 3)
			{
				deletar(scanner);
			}
			else if(escolha == 4)
			{
				visualizar();
			}
			else
			{
				system = false;
			}
        }    
    }

    public void salvar(Scanner scanner)
    {
        System.out.println("Escreva a função");
        String funcao = scanner.next();
        Cargo cargo = new Cargo();
        
        cargo.setFuncao(funcao);

        cargoRepository.save(cargo);
        System.out.println("Salvo");
    }
    public void atualizar(Scanner scanner)
    {
        System.out.println("Escreva o id");
        int id = scanner.nextInt();
        System.out.println("Escreva a função");
        String funcao = scanner.next();

        Cargo cargo = new Cargo();

        cargo.setId(id);
        cargo.setFuncao(funcao);

        cargoRepository.save(cargo);
    }
    public void deletar(Scanner scanner)
    {
        System.out.println("Escreva o id");
        int id = scanner.nextInt();

        cargoRepository.deleteById(id);
    }
    public void visualizar()
    {
        Iterable<Cargo> cargos = cargoRepository.findAll();

        cargos.forEach(cargo -> System.out.println(cargo));

    }

}
