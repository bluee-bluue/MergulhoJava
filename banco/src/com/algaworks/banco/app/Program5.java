package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Banco;
import com.algaworks.banco.modelo.Conta;

import java.math.BigDecimal;
import java.util.Optional;

public class Program5 {
    public static void main(String[] args) {
        Banco banco = new Banco();

//        Conta contaEncontrada = banco.buscar(123, 222);
//
//        if (contaEncontrada != null){
//            System.out.println(contaEncontrada.getSaldo());
//        }

//        Optional<Conta> contaOptional = banco.buscar(123, 222);

//        if (contaOptional.isPresent()) {
//            Conta contaEncontrada = contaOptional.get();
//            System.out.println(contaEncontrada.getSaldo());
//        }

//        contaOptional.ifPresent(conta -> System.out.println(conta.getSaldo()));

//        banco.buscar(123, 222)
//                .ifPresent(conta -> System.out.println(conta.getSaldo()));

//        Conta contaEncontrada = banco.buscar(123, 222)
//                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
//        System.out.println(contaEncontrada.getSaldo());

        BigDecimal saldo = banco.buscar(123, 222)
                .map(Conta::getSaldo)
                .orElse(BigDecimal.ZERO);
        System.out.println(saldo);
    }
}
