package pl.com.bottega.dms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    public void setId(long id) {
        this.id = id;
    }

}
