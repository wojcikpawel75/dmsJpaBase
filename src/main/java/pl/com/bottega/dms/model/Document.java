package pl.com.bottega.dms.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;

@Entity
public class Document {

    @Id
    @GeneratedValue
    private Long id;

    private long number;

    private String title;

    private LocalDateTime createdAt;

    private LocalDateTime verifiedAt;

    private LocalDateTime publishedAt;

    @Column(length = 1024)
    @Basic(fetch = FetchType.LAZY)
    private String content;

    @ManyToOne(optional = false)
    private Employee author;

    @ManyToOne
    private Employee verifier;

    @ManyToMany
    @JoinTable(
            name = "readers",
            joinColumns = @JoinColumn(name = "dokument_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Collection<Employee> readBy = new LinkedList<>();

    public void setId(long id) {
        this.id = id;
    }

    public void setAuthor(Employee author) {
        this.author = author;
    }
}
