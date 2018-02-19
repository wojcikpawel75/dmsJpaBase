package pl.com.bottega.dms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(mappedBy = "employee")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }
}
