package br.com.javaejpahibernate.teste;

import br.com.javaejpaehibernate.Conta;
import br.com.javaejpaehibernate.JPAUtil;

import javax.persistence.EntityManager;

public class TesteBuscaConta {

    public static void main(String... args){

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = em.find(Conta.class,1);
        conta.setTitular("Joao");
        System.out.println(conta.getTitular());
        em.getTransaction().commit();

    }
}
