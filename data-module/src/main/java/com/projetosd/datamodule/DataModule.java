package com.projetosd.datamodule;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataModule {

    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory(
                    "primary");
    }


    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
