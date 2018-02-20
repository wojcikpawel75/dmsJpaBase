package pl.com.bottega.dms.acceptance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.support.TransactionTemplate;
import pl.com.bottega.dms.model.Document;
import pl.com.bottega.dms.model.DocumentRepository;
import pl.com.bottega.dms.model.Employee;
import pl.com.bottega.dms.model.User;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JPADocumentRepositoryTest {

    @Autowired
    private DocumentRepository repository;

    @Autowired
    private TransactionTemplate tt;

    @Test
    public void savesNewDocument() {

        Employee employee = new Employee();
        Document document = new Document();

        document.setAuthor(employee);

        tt.execute((callback) -> {
            repository.save(document);
            return null;
        });

        assertThat(repository.get(document.getId())).isNotNull();

    }

    @Test
    public void removesDocument() {

        savesNewDocument();

        tt.execute((callback) -> {
            repository.remove(1L);
            return null;
        });

        assertThat(repository.get(1L)).isNull();

    }

}

