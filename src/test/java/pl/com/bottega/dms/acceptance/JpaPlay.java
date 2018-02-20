package pl.com.bottega.dms.acceptance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.support.TransactionTemplate;
import pl.com.bottega.dms.model.Document;
import pl.com.bottega.dms.model.Employee;
import pl.com.bottega.dms.model.User;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Pawel.Wojcik on 2018-02-19.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class JpaPlay {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Test
    public void testInsert() {
        Document document = new Document();
        document.setId(1L);

        transactionTemplate.execute((callback) -> {
            entityManager.persist(document);
            return null;
        });

        Document document1 = entityManager.find(Document.class, 1L);

        assertThat(document1).isNotNull();

    }


    @Test
    public void removeUser() {
        User user = new User();
        Employee employee = new Employee();
        user.setEmployee(employee);
        employee.setUser(user);

        transactionTemplate.execute(c -> {
            entityManager.persist(user);
            return null;
        });

        transactionTemplate.execute(c -> {
            User userFromDb = entityManager.find(User.class, user.getId());
            entityManager.remove(userFromDb);
            return null;
        });

        assertThat(entityManager.find(User.class, user.getId())).isNull();
        assertThat(entityManager.find(Employee.class, employee.getId())).isNull();
    }

    @Test
    public void tracksEntities() {
        User user = new User();
        Employee employee = new Employee();
        user.setEmployee(employee);
        employee.setUser(user);

        transactionTemplate.execute(c -> {
            entityManager.persist(user);
            user.setLogin("wacek");
            return null;
        });

        transactionTemplate.execute(c -> {
            User userFromDb = entityManager.find(User.class, 1L);
            userFromDb.setLogin("stefan");
            return null;
        });

        user.setLogin("stefan");

        assertThat(entityManager.find(User.class, 1L).getLogin()).isEqualTo("stefan");
    }

    @Test
    public void tracksEntities2() {
        User user = new User();
        Employee employee = new Employee();
        user.setEmployee(employee);
        employee.setUser(user);

        transactionTemplate.execute(c -> {
            entityManager.persist(user);
            user.setLogin("wacek");
            return null;
        });

        user.setLogin("krzysiek");

        transactionTemplate.execute(c -> {
            User user1 = entityManager.merge(user);
            user1.setLogin("wiesiek");
            return null;
        });

        assertThat(entityManager.find(User.class, 1L).getLogin()).isEqualTo("wiesiek");
    }
}