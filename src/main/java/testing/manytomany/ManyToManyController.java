package testing.manytomany;

import infra.singleton.GetFactoryInstance;
import model.manytomany.entity.Ator;
import model.manytomany.entity.Filme;
import model.manytomany.impl.FilmeImpl;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ManyToManyController {
    public static void main(String[] args) {
        EntityManagerFactory emf = GetFactoryInstance.getInstance();
        FilmeImpl impl = new FilmeImpl(emf.createEntityManager());

        Filme filmeA = new Filme(null,"Jogos Forazes", 8.4);
        Filme filmeB = new Filme(null,"Roberto Carlos e a saga secreta", 10.0);
        Filme filmeC = new Filme(null,"Filme de ação - Murilo Wick", 6.2);

        Ator ator1 = new Ator(null, "Murilo Pereira");
        Ator ator2 = new Ator(null, "Bruno Santos");
        Ator ator3 = new Ator(null, "Bruno Ermacora");


        filmeA.adicionaAtor(ator1);
        filmeA.adicionaAtor(ator2);
        filmeB.adicionaAtor(ator3);
        filmeC.adicionaAtor(ator2);

        try {
            print("[#] - Inserindo - [#]");
            impl.create(filmeA);
            impl.create(filmeB);
            impl.create(filmeC);
            impl.commit();
        } catch (RuntimeException e) {
            System.out.println("Erro ao dar commit");
        }

        try{
            print("[#] - BUSCAR POR NOME FILME Roberto Carlos e a saga secreta - [#]");
            Filme filmeBuscado = impl.buscarPorNome("Roberto Carlos e a saga secreta");
            System.out.println("        FILME BUSCADO");
            System.out.println("        Filme: "+filmeBuscado.getNome()+" Sua nota é: "+filmeBuscado.getNota()+" ");

        }catch(RuntimeException e){
            System.out.println("Erro ao buscar filme");
        }

        try{
            print("[#] - BUSCAR POR FILMES COM NOTA MAIOR QUE 7 - [#]");
            List<Filme> filmesMaiorQueSete = impl.filmesNotaMaioresQue(7.00);
            System.out.println("        FILMES COM NOTA MAIOR QUE 7 BUSCADO");
            for(Filme f : filmesMaiorQueSete){
                System.out.print("        Nome filme: "+f.getNome()+" sua nota foi de: "+f.getNota() + "\n");
            }

        }catch(RuntimeException e){
            System.out.println("Erro ao buscar filme");
        }

        try {
            print("[#] - BUSCAR POR NOME UPPER (jogos foRaZes)- [#]");
            List<Filme> filmeUpper = impl.findByName("jogos foRaZes");
            for(Filme movie : filmeUpper){
                System.out.println("        Nome filme: " + movie.getNome() + " Nota: " + movie.getNota());
            }

        } catch (RuntimeException e) {
            System.out.println("Erro ao buscar por nome upper");
        }

        try {
            print("[#] - BUSCAR - PAGINAR ITEMS DE 1 a 3");
            List<Filme> filmePag = impl.searchPag(3,1);
            for(Filme movie : filmePag){
                System.out.println("        Nome filme: " + movie.getNome() + " Nota: " + movie.getNota());
            }

        } catch (RuntimeException e) {
            System.out.println("Erro ao buscar por nome upper");
        }

        try {
            print("[#] - Listando - [#]");
            List<Filme> pd = impl.getAll();
            impl.commit();

            for(Filme p : pd){
                System.out.println("           Filme: " +p.getNome()+ " Nota: " +p.getNota()+ " Atores: " + p.getAtores());
            }
//            for(int a=0;a < item.getPedidos().size(); a++){
//                System.out.print(item.getPedidos().get(a));
//            }
        } catch (RuntimeException e) {
            System.out.println("Erro ao dar commit");
        }

        try {
            print("[#] - DELETAR FILME ID 1- [#]");
            impl.remove(filmeA,1);
            impl.commit();
            System.out.println("        FILME COM ID 1 - DELETADO");

        } catch (RuntimeException e) {
            System.out.println("Erro ao dar commit");
        }





    }

    static public void print(String message) {
        System.out.println(message);
    }


}
