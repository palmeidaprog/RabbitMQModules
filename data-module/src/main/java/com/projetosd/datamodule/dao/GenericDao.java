package com.projetosd.datamodule.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;

public class GenericDao {

    private static Logger LOGGER = LoggerFactory.getLogger(
            GenericDao.class.getName());

    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory(
                "primary");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

//    @PersistenceContext(name="primary")
//    private EntityManager em;

    public GenericDao() {

    }

    /**
     * Adiciona objeto ao banco
     * @param obj Objeto a ser adicionado
     * @param <T> tipo do objeto
     */
    public <T> void create(T obj) {
        if (obj == null) {
            LOGGER.error("create :: Objeto {} não pode ser nulo para ser " +
                    "adicionado", obj.getClass().getSimpleName());
            return;
        }

        EntityTransaction et = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            et = em.getTransaction();
            et.begin();
            LOGGER.debug("create :: Iniciada transação para adicionar " +
                    "objeto {}", obj.getClass().getSimpleName());

            em.persist(obj);
            et.commit();
            em.close();
            LOGGER.info("create :: Objeto {} adicionado ao banco com sucesso",
                    obj.getClass().getSimpleName());
        } catch (Exception e) {
            this.close(em, et, obj.getClass().getSimpleName());
            LOGGER.error("create :: Ocorreu um erro ao adicionar o objeto " +
                    "{} ao banco. Erro: {}", obj.getClass().getSimpleName(),
                    e.getMessage(), e);
        }
    }

    /**
     * Da roll back e fecha entity manager
     * @param em Entity Manager
     * @param et Transação
     * @param objName Nome do tipo do objeto
     */
    private void close(EntityManager em, EntityTransaction et,
                       String objName) {
        if (et != null) {
            et.rollback();
            LOGGER.debug("close :: Transação ROLLBACK para objeto {}",
                    objName);
        }

        if (em != null && em.isOpen()) {
            em.close();
            LOGGER.debug("close :: Fechando o entity manager");
        }
    }
}
