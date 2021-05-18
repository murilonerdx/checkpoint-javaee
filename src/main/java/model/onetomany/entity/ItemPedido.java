package model.onetomany.entity;

import javax.persistence.*;
import javax.transaction.Transactional;

import model.onetomany.entity.Pedido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_ITEM_PEDIDO")
@SequenceGenerator(name = "item_pedido", sequenceName = "SQ_TB_ITEM_PEDIDO", allocationSize = 1)
public class ItemPedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_pedido")
    private Integer id;

    @Column(nullable = false)
    private int qtde;

    @Column(nullable = false)
    private Double preco;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    public ItemPedido() {

    }

    public ItemPedido(Integer id, int qtde, Double preco) {
        this.id = id;
        this.preco = preco;
        this.qtde = qtde;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Item {");
        sb.append("id=").append(id);
        sb.append(", qtde=").append(qtde);
        sb.append(", preco=").append(preco);
        sb.append('}');
        return sb.toString();
    }
}