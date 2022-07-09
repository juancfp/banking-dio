package br.banking;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Conta implements IConta {

    // Controle das contas e agência
    public static int proxConta = 1;


    public static int proxAgencia = 1;

    //  Id (Primary key)
    @Id
    @Column(name = "id")
    private int id;

    // Agência
    @Column(name = "Agencia")
    protected int agencia;

    // Conta
    @Column(name = "Conta")
    protected int conta;

    // Saldo
    @Column(name = "Saldo")
    private double saldo = 0;

    // Nome
    @Column(name = "Nome")
    protected String nome;

    // Idade
    @Column(name = "Idade")
    protected int idade;

    // Estado
    @Column(name = "Estado")
    protected String estado;

    @Override
    public void saque(double valor) {
        this.saldo -= valor;

    }

    public void deposito(double valor) {
        this.saldo += valor;

    }

    public void exibirExtrato() {

    }

    public void transferir(Conta conta, double valor) {
        this.saque(valor);
        conta.deposito(valor);

    }

    // Getters
    public int getId() {
        return id;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getIdade() {
        return idade;
    }

    public String getEstado() {
        return estado;
    }

    public String getNome() {
        return nome;
    }

    public void imprimirDados() {
        System.out.println("NOME: " + nome);
        System.out.println("AGENCIA: " + agencia);
        System.out.println("CONTA: " + conta);
        System.out.printf("SALDO: R$ %.2f\n", saldo);
        System.out.println("ESTADO: "+ estado);
        System.out.println("IDADE: "+ idade);

    }

}
