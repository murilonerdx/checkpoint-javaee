package model.onetomany.impl;

import infra.dao.impl.GenericDaoImpl;
import model.manytomany.entity.Filme;
import model.onetomany.dao.PedidoDao;
import model.onetomany.entity.Pedido;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PedidoImpl extends GenericDaoImpl<Pedido, Integer> implements PedidoDao {
    public PedidoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public List<Pedido> buscarPedidosPorPrecoMenorQue(Double preco){
        TypedQuery<Pedido> query = em.createQuery("from Pedido c where c.itemPedido.preco < :preco", Pedido.class);
        query.setParameter("preco",preco);
        return query.getResultList();
    }
}
