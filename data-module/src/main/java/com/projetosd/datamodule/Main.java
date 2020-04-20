package com.projetosd.datamodule;

import com.projetosd.datamodule.dao.GenericDao;
import com.projetosd.datamodule.dataobjects.EnderecoDO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        //DataModule dm = new DataModule();

        GenericDao dao = new GenericDao();
        dao.create(test());


//        EntityManager em = DataModule.getEntityManager();
//        em.getTransaction().begin();
//        em.persist(test());
//        em.getTransaction().commit();
//        em.close();
    }

    public static EnderecoDO test() {
        EnderecoDO endereco = new EnderecoDO();
        //endereco.setId(1);
        endereco.setBairro("Graças");
        endereco.setCep(52000000);
        endereco.setRua("Av Agamenon");
        endereco.setNumero("200B");
        endereco.setEstado("PE");
        endereco.setCidade("Recife");
        return endereco;
    }
}
