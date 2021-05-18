package testing.onetoone;

import infra.singleton.GetFactoryInstance;
import model.onetoone.entity.Assento;
import model.onetoone.entity.Cliente;
import model.onetoone.impl.ClienteImpl;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class OneToOneController {
    public static void main(String[] args) {
        EntityManagerFactory fabrica = GetFactoryInstance.getInstance();
        ClienteImpl impl = new ClienteImpl(fabrica.createEntityManager());

        Assento assento1 = new Assento(null, "Assento Preferencial");
        Assento assento2 = new Assento(null, "Assento Comum");

        Cliente cliente1 = new Cliente(null, "Bruno", assento1);
        Cliente cliente2 = new Cliente(null, "Murilo", assento2);

        try {
            print("[#] - Inserindo - [#]");
            impl.create(cliente1);
            impl.create(cliente2);
            impl.commit();
        } catch (RuntimeException e) {
            System.out.println("Erro ao dar commit");
        }

        try{
            print("[#] - BUSCAR POR NOME DO CLIENTE/ASSENTO (Bruno) - [#]");
            Cliente clienteAssento = impl.buscarPorCliente("Bruno");
            System.out.println("        Cliente buscado");
            System.out.println("        Nome do cliente: "+clienteAssento.getNomeCliente()+" | Tipo de assento do cliente: "+clienteAssento.getAssento().getNomeAssento()+" ");

        }catch(RuntimeException e){
            System.out.println("Erro ao buscar cliente");
        }

        try {
            print("[#] - Listando - [#]");
            List<Cliente> pd = impl.getAll();
            impl.commit();

            for(Cliente p : pd){
                System.out.println("        ID ClIENTE: " + p.getIdCliente() + " ASSENTO: " + p.getAssento());
            }
        } catch (RuntimeException e) {
            System.out.println("Erro ao dar commit");
        }

        try {
            print("[#] - Atualizando - [#]");
            Cliente atualizaPedido = new Cliente(1, "Murilo", assento1);

            impl.update(atualizaPedido);

            Cliente pedidoAtualizado = impl.read(1);
            if (pedidoAtualizado != null) {
                System.out.println("        Pedido " + atualizaPedido.getIdCliente() + " Atualizado com sucesso\n        " + pedidoAtualizado);
            }
        } catch (RuntimeException e) {
            System.out.println("Erro ao dar commit");
        }

        try {
            print("[#] - Deletar CLIENTE ID 1- [#]");
            impl.remove(cliente1,1);
            impl.commit();
            System.out.println("        CLIENTE COM ID 1 - DELETADO");

        } catch (RuntimeException e) {
            System.out.println("Erro ao dar commit");
        }

    }

    static public void print(String message) {
        System.out.println(message);
    }
}
