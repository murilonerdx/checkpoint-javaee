package model.onetomany.dao;

import infra.dao.GenericDAO;
import model.onetomany.entity.Pedido;

import java.util.List;

public interface PedidoDao extends GenericDAO<Pedido, Integer> {
    List<Pedido> buscarPedidosPorPrecoMenorQue(Double preco);
}
