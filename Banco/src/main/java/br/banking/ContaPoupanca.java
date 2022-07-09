package br.banking;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "cp")
public class ContaPoupanca extends Conta {
    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    List<ExtratoCP> extrato = new ArrayList<>();

    // Construtores
    public ContaPoupanca(String nome, int idade, String estado) {
        this.agencia = proxAgencia;
        this.conta = proxConta++;
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    } // fim consturtor (nome, idade, estado)

    public void mostrarRendimento(){
        System.out.println("O rendimento esperado da sua conta poupança é: 5%");
    }

    @Override
    public void exibirExtrato(){
        System.out.println("INICIANDO IMPRESSÃO DO EXTRATO:");
        extrato.stream().forEach(ExtratoCP::print);
        System.out.println("FIM DA IMPRESSÃO DO EXTRATO");
    }

    public void saque(String descricao, double valor) {
        super.saque(valor);
        this.extrato.add( new ExtratoCP(this, "Saque: " + descricao, valor));
    }

    public void deposito(String descricao, double valor) {
        super.deposito(valor);
        this.extrato.add( new ExtratoCP(this, "Depósito: " + descricao, valor));
    }
    public void transferir(Conta conta, double valor) {
        super.transferir(conta, valor);
        this.extrato.add(new ExtratoCP(this, "Transferencia: Para "+conta.getNome(), valor));
    }

}

