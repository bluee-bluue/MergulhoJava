package com.algaworks.banco.app;

import com.algaworks.banco.modelo.Banco;
import com.algaworks.banco.modelo.Conta;
import com.algaworks.banco.modelo.Pessoa;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program4 {
    public static void main(String[] args) {
        Banco banco = new Banco();

        List<Pessoa> titulares = banco.getContas().stream()
                .map(Conta::getTitular)
                .distinct()
                .toList();
//                .collect(Collectors.toList());
        System.out.println(titulares);

        BigDecimal saldoTotal = banco.getContas().stream()
                .map(Conta::getSaldo)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(saldoTotal);

//        Stream<Conta> stream = banco.getContas().stream();
//        Stream<Conta> stream2 = stream.filter(conta ->
//                conta.getSaldo().compareTo(new BigDecimal("130")) > 0);
//        Stream<Conta> stream3 = stream2.filter(conta -> conta.getNumero() > 300);

//        stream3.forEach(conta -> {
//            System.out.println(conta.getAgencia() + "/" + conta.getNumero()
//                    + " = " + conta.getSaldo());
//        });

//        banco.getContas().stream()
//                .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("130")) > 0)
//                .filter(conta -> conta.getNumero() > 100)
//                .sorted(Comparator.comparingInt(Conta::getNumero))
//                .forEach(conta -> {
//                    System.out.println(conta.getAgencia() + "/" + conta.getNumero()
//                        + " = " + conta.getSaldo());
//                });

        banco.getContas().stream()
                .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("130")) > 0)
                .filter(conta -> conta.getNumero() > 100)
                .map(Conta::getTitular)
                .distinct()
                .forEach(System.out::println);
    }
}
