package pl.com.bottega.dms.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 * Created by Pawel.Wojcik on 2018-02-20.
 */

@Embeddable
public class PhoneNumber {

    String countryCode;

    String number;

}
