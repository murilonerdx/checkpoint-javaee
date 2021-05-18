package model.onetomany.impl;

import infra.dao.impl.GenericDaoImpl;
import model.onetomany.dao.ItemPedidoDao;
import model.onetomany.dao.PedidoDao;
import model.onetomany.entity.ItemPedido;
import model.onetomany.entity.Pedido;

import javax.persistence.EntityManager;

public class ItemPedidoImpl extends GenericDaoImpl<ItemPedido, Integer> implements ItemPedidoDao {
    public ItemPedidoImpl(EntityManager em) {
        super(em);
    }
}
