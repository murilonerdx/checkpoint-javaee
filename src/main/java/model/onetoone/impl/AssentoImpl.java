package model.onetoone.impl;

import infra.dao.impl.GenericDaoImpl;
import model.onetoone.dao.AssentoDao;
import model.onetoone.entity.Assento;

import javax.persistence.EntityManager;

public class AssentoImpl extends GenericDaoImpl<Assento, Integer> implements AssentoDao {
    public AssentoImpl(EntityManager em) {
        super(em);
    }
}
