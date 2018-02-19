import pl.com.bottega.dms.model.Document;
import pl.com.bottega.dms.model.Employee;
import pl.com.bottega.dms.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NoSpringApp {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DMS");
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    User user = new User();
    Employee employee = new Employee();

    user.setEmployee(employee);
    employee.setUser(user);

    em.persist(employee);
    em.persist(user);

    Document document = new Document();
    document.setAuthor(employee);
    em.persist(document);

    employee.addCreatedDocument(document);

    document = new Document();
    document.setAuthor(employee);
    em.persist(document);

    employee.addCreatedDocument(document);

    em.persist(employee);
    //em.persist(user);
    //document.setId(2L);
    //em.persist(document);

    em.flush();
    em.getTransaction().commit();
    emf.close();
  }

}
