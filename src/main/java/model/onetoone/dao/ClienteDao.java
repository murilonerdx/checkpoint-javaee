package model.onetoone.dao;

import infra.dao.GenericDAO;
import model.onetoone.entity.Cliente;

public interface ClienteDao extends GenericDAO<Cliente, Integer> {

    Cliente buscarPorCliente(String nomeCliente);
}
