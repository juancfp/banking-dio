package br.banking;

public interface IConta {

    void saque(double valor);

    void deposito(double valor);

    void exibirExtrato();

    void transferir(Conta conta, double valor);

    void imprimirDados();
}
