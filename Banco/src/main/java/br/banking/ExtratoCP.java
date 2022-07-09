package br.banking;

import jakarta.persistence.Entity;

@Entity(name = "extrato_cp")
public class ExtratoCP extends Extrato {
    public ExtratoCP(){

    }
    public ExtratoCP(Conta conta, String descricao, double valor){
        super(conta, descricao, valor);
    }
}
