package com.example.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import com.example.springdata.CrudService.CrudCargoService;
import com.example.springdata.CrudService.CrudFuncionarioService;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner 
{
	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private Boolean system = true;

	public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService)
	{
		this.cargoService = cargoService; 
		this.funcionarioService = funcionarioService;
	}
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		Scanner scanner = new Scanner(System.in);
		while (system)
		{
			System.out.println("Opções");
			System.out.println("0 - SAIR");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");

			int escolha = scanner.nextInt();
			if(escolha == 1)
			{
				cargoService.inicial(scanner);
			}
			else if(escolha == 2)
			{
				funcionarioService.inicial(scanner);
			}
			else
			{
				system = false;
			}
		}
	}


}
