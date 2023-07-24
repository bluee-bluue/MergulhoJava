package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Banco;
import com.algaworks.banco.modelo.Conta;

import java.util.Comparator;
import java.util.function.ToIntFunction;

public class Program3 {
    public static void main(String[] args) {
        Banco banco = new Banco();

//        ToIntFunction<Conta> function = (Conta conta) -> {
//            return conta.getNumero();
//        };

        ToIntFunction<Conta> function = Conta::getNumero;

//        banco.getContas().sort(Comparator.comparingInt(new NumeroContaFunction()));
//        banco.getContas().sort(Comparator.comparingInt(function));
        banco.getContas().sort(Comparator.comparingInt(Conta::getNumero));

        for (Conta conta : banco.getContas()){
            System.out.println(conta.getAgencia() + "/" + conta.getNumero());
        }
    }
}
