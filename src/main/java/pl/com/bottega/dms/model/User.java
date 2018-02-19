package pl.com.bottega.dms.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String login;

    private String password;

    @OneToOne(optional = false)
    //@PrimaryKeyJoinColumn
    private Employee employee;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
