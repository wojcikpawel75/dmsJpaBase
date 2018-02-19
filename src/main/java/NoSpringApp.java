import pl.com.bottega.dms.model.Document;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NoSpringApp {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DMS");
    EntityManager em = emf.createEntityManager();
    em.persist(new Document());
    em.flush();
    emf.close();
  }

}
