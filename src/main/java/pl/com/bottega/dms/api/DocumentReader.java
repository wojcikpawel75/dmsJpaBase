package pl.com.bottega.dms.api;

import pl.com.bottega.dms.model.Document;

import java.util.List;

public interface DocumentReader {

    List<Document> searchDocuments(DocumentSearchCriteria criteria);

    List<DocumentDto> searchDocumentDtos(DocumentSearchCriteria criteria);

}
