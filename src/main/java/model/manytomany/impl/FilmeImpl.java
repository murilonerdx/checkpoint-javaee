package model.manytomany.impl;

import infra.dao.impl.GenericDaoImpl;
import model.manytomany.dao.FilmeDao;
import model.manytomany.entity.Filme;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FilmeImpl extends GenericDaoImpl<Filme, Integer> implements FilmeDao {
    public FilmeImpl(EntityManager em) {
        super(em);
    }

    @Override
    public List<Filme> filmesNotaMaioresQue(Double nota){
        TypedQuery<Filme> query = em.createQuery("from Filme c where c.nota > :nota", Filme.class);
        query.setParameter("nota",nota);
        return query.getResultList();
    }

    @Override
    public List<Filme> findByName(String nome) {
        return em.createQuery("from Filme c where upper(c.nome) like upper(:pNome) order by c.nome desc", Filme.class)
                .setParameter("pNome", "%" + nome + "%")
                .getResultList();
    }

    @Override
    public List<Filme> searchPag(int maximo, int primeiro) {
        return em.createQuery("from Filme", Filme.class)
                .setMaxResults(maximo)
                .setFirstResult(primeiro)
                .getResultList();
    }
}
