package br.com.javaejpahibernate.teste;

import br.com.javaejpaehibernate.Conta;
import br.com.javaejpaehibernate.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteConta {
    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setTitular("Leonardo");
        conta.setBanco("Caixa Economica");
        conta.setAgencia("123");
        conta.setNumero("456");


        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();

        em.close();
    }
}


