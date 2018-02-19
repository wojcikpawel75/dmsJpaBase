package pl.com.bottega.dms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class User {

    @Id
    private long id;

    private String login;

    private String password;

    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    private Employee employee;

}
