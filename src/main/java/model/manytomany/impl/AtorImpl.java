package model.manytomany.impl;

import infra.dao.impl.GenericDaoImpl;
import model.manytomany.dao.AtorDao;
import model.manytomany.entity.Ator;

import javax.persistence.EntityManager;

public class AtorImpl extends GenericDaoImpl<Ator, Integer> implements AtorDao {
    public AtorImpl(EntityManager em) {
        super(em);
    }
}
