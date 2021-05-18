package model.manytomany.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="TB_FILME")
@SequenceGenerator(allocationSize = 1, sequenceName = "SQ_TB_FILME",name = "filme")
public class Filme {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="filme")
    private Integer id;
    @Column(name="ds_nome")
    private String nome;
    @Column(name="vl_nota")
    private Double nota;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinTable(name="TB_FILME_ATOR", joinColumns = {@JoinColumn(name="filme_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="ator_id", referencedColumnName = "id")})
    private List<Ator> atores = new ArrayList<>();



    public Filme(Integer id, String nome, Double nota) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
    }

    public Filme() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public List<Ator> getAtores() {
        return atores;
    }


    public Double getNota() {
        return nota;
    }



    public void adicionaAtor(Ator ator){
        if(ator!=null && !getAtores().contains(ator)){
            getAtores().add(ator);
            if(!ator.getFilmes().contains(this)){
                ator.getFilmes().add(this);
            }
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ator{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", nota=").append(nota);
        sb.append('}');
        return sb.toString();
    }
}
