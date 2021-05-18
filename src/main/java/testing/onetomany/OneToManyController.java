package testing.onetomany;

import infra.singleton.GetFactoryInstance;
import model.onetomany.entity.ItemPedido;
import model.onetomany.entity.Pedido;
import model.onetomany.impl.ItemPedidoImpl;
import model.onetomany.impl.PedidoImpl;

import javax.persistence.EntityManagerFactory;
import java.util.*;

public class OneToManyController {
    public static void main(String[] args) {
        EntityManagerFactory emf = GetFactoryInstance.getInstance();
        PedidoImpl impl = new PedidoImpl(emf.createEntityManager());
        ItemPedidoImpl implItem = new ItemPedidoImpl(emf.createEntityManager());

        ItemPedido itemPedido1 = new ItemPedido(null, 2, 2.50);
        ItemPedido itemPedido2 = new ItemPedido(null, 5, 7.50);
        ItemPedido itemPedido3 = new ItemPedido(null, 6, 4.60);


        Pedido pedido1 = new Pedido(null, Calendar.getInstance(), itemPedido1);
        Pedido pedido2 = new Pedido(null, Calendar.getInstance(), itemPedido3);
        Pedido pedido3 = new Pedido(null, Calendar.getInstance(), itemPedido2);

        try {
            print("[#] - Inserindo - [#]");
            impl.create(pedido1);
            impl.create(pedido2);
            impl.create(pedido3);
            impl.commit();
        } catch (RuntimeException e) {
            System.out.println("Erro ao dar commit");
        }

        try{
            print("[#] - BUSCAR POR PRODUTOS COM PREÇOS MENORES QUE R$3.00 - [#]");
            List<Pedido> produtos = impl.buscarPedidosPorPrecoMenorQue(3.00);
            for(Pedido f : produtos){
                System.out.println("        ITEM PEDIDO: "+f.getItemPedido());
            }

        }catch(RuntimeException e){
            System.out.println("Erro ao buscar preços");
        }


        try {
            print("[#] - Listando - [#]");
            List<Pedido> pd = impl.getAll();
            implItem.commit();

            for(Pedido p : pd){
                System.out.println("        ID PEDIDO: " + p.getId() + " ID ITEM: " + p.getItemPedido());
            }
//            for(int a=0;a < item.getPedidos().size(); a++){
//                System.out.print(item.getPedidos().get(a));
//            }
        } catch (RuntimeException e) {
            System.out.println("Erro ao dar commit");
        }


        try {
            print("[#] - Atualizar - [#]");

            ItemPedido itemPedidoNovo = new ItemPedido(null, 6, 1.50);
            Pedido atualizaPedido = new Pedido(1, Calendar.getInstance(), itemPedidoNovo);

            impl.update(atualizaPedido);

            Pedido pedidoAtualizado = impl.read(1);
            if (pedidoAtualizado != null) {
                System.out.println("        Pedido " + atualizaPedido.getId() + " Atualizado com sucesso\n        " + pedidoAtualizado);
            }

        } catch (RuntimeException e) {
            System.out.println("Erro ao dar commit");
        }


        try {
            print("[#] - Deletar PEDIDO ID 1 - [#]");
            impl.remove(pedido1,1);
            impl.commit();
            System.out.println("        PEDIDO COM ID 1 - DELETADO");

        } catch (RuntimeException e) {
            System.out.println("Erro ao dar commit");
        }




//        try {
//            print("[#] - BUSCAR POR NOME UPPER (jogos foRaZes)- [#]");
//            List<Filme> filmeUpper = impl.findByName("jogos foRaZes");
//            for(Filme movie : filmeUpper){
//                System.out.println("        Nome filme: " + movie.getNome() + " Nota: " + movie.getNota());
//            }
//
//        } catch (RuntimeException e) {
//            System.out.println("Erro ao buscar por nome upper");
//        }
    }

    static public void print(String message) {
        System.out.println(message);
    }


}
