package model.onetoone.impl;

import infra.dao.impl.GenericDaoImpl;
import model.onetoone.dao.*;
import model.onetoone.entity.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ClienteImpl extends GenericDaoImpl<Cliente, Integer> implements ClienteDao {

    public ClienteImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Cliente buscarPorCliente(String nomeCliente) {
        TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.nomeCliente =:nomeCliente",Cliente.class);
        query.setParameter("nomeCliente",nomeCliente);
        return query.getSingleResult();
    }
}
