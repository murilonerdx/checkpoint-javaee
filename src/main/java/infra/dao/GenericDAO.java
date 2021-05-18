package infra.dao;

import infra.exceptions.CommitException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface GenericDAO<O,I> {
    void create(O obj);
    O read(I id);
    void update(O obj);
    void remove(O obj, I id);
    void commit() throws CommitException;
    List<O> getAll();
    O buscarPorNome(String nome);

}
