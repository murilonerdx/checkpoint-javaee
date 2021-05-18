package model.onetoone.entity;

import javax.persistence.*;

@Entity
@Table(name="TB_ASSENTO")
@SequenceGenerator(name="assento", sequenceName = "SQ_TB_ASSENTO", allocationSize = 1)
public class Assento {

    @Id
    @GeneratedValue(generator = "assento", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_assento")
    private Integer idAssento;

    @Column(name = "nm_assento", length = 60)
    private String nomeAssento;

    @OneToOne(mappedBy = "assento")
    private Cliente cliente;

    public Assento(Integer idAssento, String nomeAssento) {
        this.idAssento = idAssento;
        this.nomeAssento = nomeAssento;
    }

    public Assento(){

    }

    public int getIdAssento() {
        return idAssento;
    }

    public void setIdAssento(Integer idAssento) {
        this.idAssento = idAssento;
    }

    public String getNomeAssento() {
        return nomeAssento;
    }

    public void setNomeAssento(String nomeAssento) {
        this.nomeAssento = nomeAssento;
    }

    @Override
    public String toString() {
        return "Assento{" +
                "idAssento=" + idAssento +
                ", nomeAssento='" + nomeAssento + '\'' +
                '}';
    }
}
