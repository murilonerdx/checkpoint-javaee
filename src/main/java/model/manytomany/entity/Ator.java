package model.manytomany.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TB_ATOR")
@SequenceGenerator(allocationSize = 1, sequenceName = "SQ_TB_ATOR",name = "ator")
public class Ator {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="ator")
    private Integer id;
    @Column(name="ds_nome")
    private String nome;


    @ManyToMany(mappedBy = "atores")
    private List<Filme> filmes = new ArrayList<>();

    public Ator(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Ator() {
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ator{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

}
