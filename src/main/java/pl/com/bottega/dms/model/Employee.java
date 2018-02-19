package pl.com.bottega.dms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {

    @Id
    private long id;

    @OneToOne(mappedBy = "employee")
    private User user;

}
