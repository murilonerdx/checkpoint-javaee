package infra.dao.impl;

import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import java.lang.reflect.*;
import java.util.List;

import infra.dao.GenericDAO;
import infra.exceptions.CommitException;

public abstract class GenericDaoImpl<O,I> implements GenericDAO<O,I> {

    protected EntityManager em;

    private Class<O> clazz;

    @SuppressWarnings("all")
    public GenericDaoImpl(EntityManager em) {
        this.em = em;
        this.clazz = (Class<O>) ((ParameterizedType)
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    @Override
    public void create(O entidade) {
        em.persist(entidade);
    }

    @Override
    public O read(I id) throws EntityNotFoundException {
        O entidade = em.find(clazz, id);
        if (entidade == null ) {
            throw new EntityNotFoundException();
        }
        return entidade;

    }

    @Override
    public void update(O entidade) {
        em.merge(entidade);
    }

    @Override
    public void remove(O obj,I id) throws EntityNotFoundException {
        O removeObj = em.find(clazz, id);
        em.remove(removeObj);
    }

    @Override
    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new CommitException("Erro ao dar commit");
        }
    }

    @Override
    public List<O> getAll() {
        String jpql = "select e from " + clazz.getName() + " e";
        TypedQuery<O> query = em.createQuery(jpql, clazz);
        return query.getResultList();
    }

    @Override
    public O buscarPorNome(String nome){
        TypedQuery<O> query = em.createQuery("from " + clazz.getName() + " c where c.nome = :nome", clazz);
        query.setParameter("nome",nome);
        return query.getSingleResult();
    }



}
