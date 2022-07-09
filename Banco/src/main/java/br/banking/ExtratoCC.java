package br.banking;

import jakarta.persistence.*;

@Entity(name = "extrato_cc")
public class ExtratoCC extends Extrato{
    public ExtratoCC() {

    }
    public ExtratoCC(Conta conta, String descricao, double valor){
        super(conta, descricao, valor);
    }
}
