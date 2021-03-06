package com.projetosd.datamodule.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class DaoGenerico<T, K> {

    private static Logger LOGGER = LoggerFactory.getLogger(
            DaoGenerico.class.getName());

    private final static EntityManagerFactory emf;

    private final Class<T> type;

    static {
        emf = Persistence.createEntityManagerFactory(
                "primary");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DaoGenerico(Class<T> type) {
        this.type = type;
    }

    protected T procurar(K key) {
        if (key == null) {
            LOGGER.error("procurar :: Chave {} do Objeto nao pode ser " +
                    "nulo", key.getClass().getSimpleName());
            return null;
        }

        EntityTransaction et = null;
        EntityManager em = null;
        T retorno = null;
        try {
            em = getEntityManager();
            et = em.getTransaction();
            et.begin();

            retorno = em.find(this.type, key);
            et.commit();
            em.close();

            return retorno;
        } catch (Exception e) {
            LOGGER.error("procurar :: Ocorreu um erro ao procurar o objeto" +
                    " {} com chave primaria {}. Erro: {}", type.getSimpleName(),
                    key.getClass().getSimpleName(), e.getMessage(), e);
            this.close(em, et, this.type.getSimpleName());
            return null;
        }
    }


    /**
     * Adiciona objeto ao banco
     * @param obj Objeto a ser adicionado
     */
    protected void inserir(T obj) {
        if (obj == null) {
            LOGGER.error("inserir :: Objeto {} não pode ser nulo para ser " +
                    "adicionado", obj.getClass().getSimpleName());
            return;
        }

        EntityTransaction et = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            et = em.getTransaction();
            et.begin();
            LOGGER.debug("inserir :: Iniciada transação para adicionar " +
                    "objeto {}", obj.getClass().getSimpleName());

            em.persist(obj);
            et.commit();
            em.close();
        } catch (Exception e) {
            LOGGER.error("inserir :: Ocorreu um erro ao adicionar o objeto " +
                            "{} ao banco. Erro: {}", obj.getClass().getSimpleName(),
                    e.getMessage(), e);
            this.close(em, et, obj.getClass().getSimpleName());
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
