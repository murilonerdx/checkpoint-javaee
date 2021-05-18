package model.onetomany.entity;


import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_PEDIDOS")
@SequenceGenerator(name = "pedido", sequenceName = "SQ_TB_PEDIDO", allocationSize = 1)
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
    private Integer id;

    @Column(nullable = false)
    private Calendar data;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "itemPedido_id")
    private ItemPedido itemPedido;

    public Pedido() {

    }

    public Pedido(Integer id, Calendar data, ItemPedido item) {
        this.id = id;
        this.data = data;
        this.itemPedido = item;
    }

    public Integer getId() {
        return id;
    }

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pedido{");
        sb.append("id=").append(id);
        sb.append(", data=").append(data);
        sb.append(", itemPedido=").append(itemPedido);
        sb.append('}');
        return sb.toString();
    }
}