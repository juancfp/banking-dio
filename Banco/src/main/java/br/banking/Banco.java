package br.banking;

import jakarta.persistence.*;

import java.util.Scanner;

public class Banco
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banking");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner in = new Scanner(System.in);

        // CRIAR CONTA
        System.out.println("CRIANDO UMA CONTA: ");
        System.out.println("DIGITE O NOME: ");
        String nome = in.nextLine();
        System.out.println("DIGITE A IDADE: ");
        int idade = in.nextInt();
        in.nextLine();
        System.out.println("DIGITE A UF(2 LETRAS): ");
        String estado = in.nextLine();

        try {
            entityManager.getTransaction().begin();
            ContaCorrente conta = new ContaCorrente(nome, idade, estado);
            entityManager.persist(conta);
            entityManager.getTransaction().commit();

            System.out.println("CONTA CRIADA COM SUCESSO");
            System.out.println("DADOS DA SUA CONTA:");
            conta.imprimirDados();
        } catch (Exception e) {
            System.out.println("ERRO AO CRIAR SUA CONTA...");
            e.printStackTrace();
        }

        entityManager.close();
        entityManagerFactory.close();
    } // fim do método main

}
