package model.manytomany.dao;

import infra.dao.GenericDAO;
import model.manytomany.entity.Filme;

import java.util.List;

public interface FilmeDao extends GenericDAO<Filme, Integer> {
    List<Filme> filmesNotaMaioresQue(Double nota);
    List<Filme> findByName(String nome);
    List<Filme> searchPag(int maximo,int primeiro);


}
