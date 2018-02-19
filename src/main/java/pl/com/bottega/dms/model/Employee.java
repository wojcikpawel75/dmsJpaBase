package pl.com.bottega.dms.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(mappedBy = "employee")
    private User user;

    @OneToMany(mappedBy = "author")
    private Collection<Document> createdDokuments = new LinkedList<>();

    @OneToMany(mappedBy = "verifier")
    private Collection<Document> verifiedDokuments = new LinkedList<>();

    @ManyToMany(mappedBy = "readBy")
    private Collection<Document> readDokuments = new LinkedList<>();

    public void setUser(User user) {
        this.user = user;
    }

    public void addCreatedDocument(Document document) {
        createdDokuments.add(document);
    }
}
