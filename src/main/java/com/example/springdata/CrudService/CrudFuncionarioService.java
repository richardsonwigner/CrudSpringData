package com.example.springdata.CrudService;

import java.util.Optional;
import java.util.Scanner;

import com.example.springdata.ORM.Cargo;
import com.example.springdata.ORM.Funcionario;
import com.example.springdata.Repository.CargoRepository;
import com.example.springdata.Repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CrudFuncionarioService
{
    private final FuncionarioRepository funcionarioRepository;

    private final CargoRepository cargoRepository;

    public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository)
    {
        this.funcionarioRepository = funcionarioRepository;
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
    public void visualizar()
    {
        Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
        
        funcionarios.forEach(funcionario -> System.out.println(funcionario));
    }
    public void salvar(Scanner scanner)
    {
        System.out.println("Nome");
        String nome = scanner.next();

        System.out.println("CPF");
        String cpf = scanner.next();

        System.out.println("Salario");
        double salario = scanner.nextInt();

        System.out.println("ID do cargo");
        int idCargo = scanner.nextInt();


        Funcionario funcionario = new Funcionario();

        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        Optional<Cargo> cargo = cargoRepository.findById(idCargo);

        funcionario.setCargo(cargo.get());

        funcionarioRepository.save(funcionario);


    }
    public void atualizar(Scanner scanner)
    {
        System.out.println("ID");
        Integer id = scanner.nextInt();

        System.out.println("Salario");
        double salario = scanner.nextInt();


        Funcionario funcionario = new Funcionario();

        funcionario.setId(id);
        funcionario.setSalario(salario);

        funcionarioRepository.save(funcionario);

    }
    public void deletar(Scanner scanner)
    {
        System.out.println("ID");
        Integer id = scanner.nextInt();

        funcionarioRepository.deleteById(id);

    }
}
