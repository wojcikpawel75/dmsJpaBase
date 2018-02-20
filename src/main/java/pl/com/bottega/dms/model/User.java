package pl.com.bottega.dms.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String login;

    private String password;

    @OneToOne(optional = false)
    //@PrimaryKeyJoinColumn
    @Cascade(CascadeType.ALL)
    private Employee employee;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
