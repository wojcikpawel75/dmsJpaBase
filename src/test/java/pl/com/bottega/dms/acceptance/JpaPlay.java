package pl.com.bottega.dms.acceptance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.support.TransactionTemplate;
import pl.com.bottega.dms.model.Document;

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

}
