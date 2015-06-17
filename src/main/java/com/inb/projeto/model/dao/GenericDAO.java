package com.inb.projeto.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class GenericDAO<E> {

    protected EntityManager entityManager;

    protected Class<E> entity;

    public GenericDAO(Class<E> entity) {
        this.entity = entity;
    }

    public GenericDAO() {

    }

    /**
     * objeto que cuidara do contexto da aplicacao
     *
     * @param entityManager
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Metodo de salvar usuario utilizando gerencidor do spring com a anotacao
     *
     * @Transactional
     *
     * @param entity
     * @throws DAOException
     */
    @Transactional
    public void salvar(E entity) throws DAOException {
        try {
            entityManager.persist(entity);
        } catch (Exception e) {
            throw new DAOException("Nao foi possivel salvar", e);
        }
    }

    /**
     *
     * @param entity
     * @throws DAOException
     */
    @Transactional
    public void atualiza(E entity) throws DAOException {
        try {
            entityManager.merge(entity);
        } catch (Exception e) {
            throw new DAOException("Nao foi possivel atualizar", e);
        }
    }

    /**
     * remove do banco o dados passados pelo objeto. a coluna especifica.
     *
     * @param contato
     * @throws com.inb.projeto.model.dao.DAOException
     */
    @Transactional
    public void deleta(E contato) throws DAOException {
        try {
            entityManager.remove(contato);
        } catch (Exception e) {
            throw new DAOException("Nao foi possivel deletar", e);
        }
    }

    public E findById(Integer id) {

        return entityManager.find(entity, id);

    }

    // Metodo de retornar a lista de usuarios
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<E> getAll() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entity));

        return entityManager.createQuery(cq).getResultList();
    }

    // Metodo de retornar o usuario por ID
}
