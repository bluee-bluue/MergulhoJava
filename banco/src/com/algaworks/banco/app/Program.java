package com.algaworks.banco.app;

import com.algaworks.banco.modelo.*;
import com.algaworks.banco.modelo.atm.CaixaEletronico;
import com.algaworks.banco.modelo.excecao.SaldoInsuficienteException;
import com.algaworks.banco.modelo.pagamento.Boleto;
import com.algaworks.banco.modelo.pagamento.DocumentoPagavel;
import com.algaworks.banco.modelo.pagamento.Holerite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("Sergio Caique da Silva");
        titular1.setDocumento("12309845687");
        titular1.setRendimentoAnual(new BigDecimal("15000"));
        titular1.setTipo(TipoPessoa.FISICA);
        titular1.setDataUltimaAtualizacao(LocalDateTime.parse("2023-07-27T23:40:00"));

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Maria Andrade da Silva");
        titular2.setDocumento("09812376545");
        titular2.setTipo(TipoPessoa.JURIDICA);

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 123, 456);
        ContaEspecial suaConta = new ContaEspecial(titular2, 987, 654, new BigDecimal("1000"));

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        try {
            minhaConta.depositar(new BigDecimal("40000"));
            minhaConta.sacar(new BigDecimal("4000"));
            minhaConta.debitarTarifaMensal();

            suaConta.depositar(new BigDecimal("15000"));
            suaConta.sacar(new BigDecimal("15500"));
            suaConta.debitarTarifaMensal();

            Boleto boletoEscola = new Boleto(titular2, new BigDecimal("3000"));
            Holerite salarioFuncionario = new Holerite(titular2, new BigDecimal("100"), 160);

            caixaEletronico.pagar(boletoEscola, minhaConta);
            caixaEletronico.pagar(salarioFuncionario, minhaConta);

            caixaEletronico.estornarPagamento(boletoEscola, minhaConta);

            boletoEscola.imprimirRecibo();
            salarioFuncionario.imprimirRecibo();
        } catch (SaldoInsuficienteException e){
            System.out.println("Erro ao executar a operação na conta: " + e.getMessage());
        }

        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);
    }
}
