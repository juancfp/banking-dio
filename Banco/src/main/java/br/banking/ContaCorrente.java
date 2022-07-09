package br.banking;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "cc")
public class ContaCorrente extends Conta{

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    List<ExtratoCC> extrato = new ArrayList<>();

    public ContaCorrente(String nome, int idade, String estado) {
        this.agencia = proxAgencia;
        this.conta = proxConta++;
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    }

    public ContaCorrente(){

    }

    public void mostrarServicosDisponiveis() {
        System.out.println("Seus serviços disponíveis para sua conta corrente são:");
        System.out.println("Sala VIP em aeroportos;");
        System.out.println("Cartão de crédito Black;");
    }

    @Override
    public void exibirExtrato(){
        System.out.println("INICIANDO IMPRESSÃO DO EXTRATO:");
        extrato.stream().forEach(ExtratoCC::print);
        System.out.println("FIM DA IMPRESSÃO DO EXTRATO");
    }

    public void saque(String descricao, double valor) {
        super.saque(valor);
        this.extrato.add( new ExtratoCC(this, "Saque: " + descricao, valor));
    }


    public void deposito(String descricao, double valor) {
        super.deposito(valor);
        this.extrato.add( new ExtratoCC(this, "Depósito: " + descricao, valor));
    }

    public void transferir(Conta conta, double valor) {
        super.transferir(conta, valor);
        this.extrato.add(new ExtratoCC(this, "Transferencia: Para "+conta.getNome(), valor));
    }
}
