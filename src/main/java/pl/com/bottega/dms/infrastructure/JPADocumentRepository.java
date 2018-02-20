package pl.com.bottega.dms.infrastructure;

import org.springframework.stereotype.Component;
import pl.com.bottega.dms.model.Document;
import pl.com.bottega.dms.model.DocumentNotFoundException;
import pl.com.bottega.dms.model.DocumentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class JPADocumentRepository implements DocumentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Document get(Long id) throws DocumentNotFoundException {
        return entityManager.find(Document.class, id);
    }

    @Override
    public void save(Document document) {

        entityManager.persist(document);

    }

    @Override
    public void remove(Long id) throws DocumentNotFoundException {

        entityManager.remove(get(id));

    }
}

