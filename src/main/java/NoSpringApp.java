import pl.com.bottega.dms.model.Document;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NoSpringApp {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DMS");
    EntityManager em = emf.createEntityManager();
    Document document = new Document();
    //document.setId(2L);
    em.getTransaction().begin();
    em.persist(document);
    em.flush();
    em.getTransaction().commit();
    emf.close();
  }

}
