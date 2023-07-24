package com.algaworks.banco.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {
    private List<Conta> contas = new ArrayList<>();

    public Banco(){
        Pessoa pessoa1 = new Pessoa("Caique Silva", "52682857850");
        Pessoa pessoa2 = new Pessoa("Matheus Alves", "32586895145");

        Conta conta1 = new ContaInvestimento(pessoa1, 123, 111);
        Conta conta2 = new ContaInvestimento(pessoa1, 123, 222);
        Conta conta3 = new ContaInvestimento(pessoa2, 123, 333);
        Conta conta4 = new ContaEspecial(pessoa1, 123, 122, new BigDecimal("1000"));
        Conta conta5 = new ContaEspecial(pessoa2, 123, 133, new BigDecimal("1000"));

        conta1.depositar(new BigDecimal("120"));
        conta2.depositar(new BigDecimal("150"));
        conta3.depositar(new BigDecimal("500"));
        conta5.depositar(new BigDecimal("12000"));

        contas.add(conta1);
        contas.add(conta2);
        contas.add(conta3);
        contas.add(conta4);
        contas.add(conta5);


    }

    public List<Conta> getContas(){
        return contas;
    }

    public Optional<Conta> buscar(int agencia, int numero){
        for (Conta conta : getContas()){
            if (conta.getAgencia() == agencia
                    && conta.getNumero() == numero){
                return Optional.of(conta);
            }
        }
        return Optional.empty();
    }

//    public Conta buscar(int agencia, int numero){
//        for (Conta conta : getContas()){
//            if (conta.getAgencia() == agencia
//                    && conta.getNumero() == numero){
//                return conta;
//            }
//        }
//        return null;
//    }
}
