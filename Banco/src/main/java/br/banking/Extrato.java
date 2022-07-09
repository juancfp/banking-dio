package br.banking;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Extrato {
    @Id
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name = "fk_idConta")
    private Conta conta;

    @Column(name = "Descricao")
    private String descricao;

    @Column(name = "Valor")
    private double valor;

    public Extrato(){

    }

    public void print(){
        System.out.printf("%s - R$ %.2f\n", descricao, valor);
    }

    public Extrato(Conta conta, String descricao, double valor) {
        this.conta = conta;
        this.descricao = descricao;
        this.valor = valor;
    }
}
