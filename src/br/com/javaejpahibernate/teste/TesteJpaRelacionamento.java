package br.com.javaejpahibernate.teste;

import br.com.javaejpaehibernate.Conta;
import br.com.javaejpaehibernate.JPAUtil;
import br.com.javaejpaehibernate.Movimentacao;
import br.com.javaejpaehibernate.TipoMovimentacao;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Calendar;

public class TesteJpaRelacionamento {
    public static void main(String... args){

        Conta conta = new Conta();
        conta.setTitular("Leonardo");
        conta.setBanco("Caixa Economica");
        conta.setAgencia("123");
        conta.setNumero("456");

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Conta de luz - ABRIL/2012");
        movimentacao.setValor(new BigDecimal("135"));
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setConta(conta);

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(conta);
        em.persist(movimentacao);

        em.getTransaction().commit();

        em.close();
    }
}
