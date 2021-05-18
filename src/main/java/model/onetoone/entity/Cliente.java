package model.onetoone.entity;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(name = "cliente", sequenceName = "SQ_TB_CLIENTE", allocationSize = 1)
public class Cliente {

    @Id
    @Column(name = "cd_cliente")
    @GeneratedValue(generator = "cliente", strategy=GenerationType.SEQUENCE)
    private Integer idCliente;

    @Column(name="nm_cliente", length = 120)
    private String nomeCliente;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Assento assento;

    public Cliente(Integer idCliente, String nomeCliente, Assento assento) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.assento = assento;
    }

    public Cliente(){}

    public int getIdCliente() {
        return idCliente;
    }



    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cliente{");
        sb.append("idCliente=").append(idCliente);
        sb.append(", nomeCliente='").append(nomeCliente).append('\'');
        sb.append(", assento=").append(assento);
        sb.append('}');
        return sb.toString();
    }
}
