package pl.com.bottega.dms.acceptance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.support.TransactionTemplate;
import pl.com.bottega.dms.model.*;

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

    @Test(expected = DocumentNotFoundException.class)
    public void throwsExceptionWhenIDIsInvalid() {
        repository.get(9999L);
    }

    @Test(expected = DocumentNotFoundException.class)
    public void removesDocument() {

        Employee employee = new Employee();
        Document document = new Document();

        document.setAuthor(employee);

        tt.execute((callback) -> {
            repository.save(document);
            return null;
        });

        tt.execute((callback) -> {
            repository.remove(document.getId());
            return null;
        });

        repository.get(document.getId());

    }

    @Test(expected = DocumentNotFoundException.class)
    public void throwsExceptionWhenRemovingNonExistingDocument () {

        repository.remove(999L);
    }

}

