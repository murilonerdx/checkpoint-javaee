package infra.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetFactoryInstance {

    private static EntityManagerFactory fabrica ;

    public static EntityManagerFactory  getInstance() {
        if (fabrica == null) {
            fabrica = Persistence.createEntityManagerFactory("oracle");
        }
        return fabrica;
    }

    private GetFactoryInstance () {}


}