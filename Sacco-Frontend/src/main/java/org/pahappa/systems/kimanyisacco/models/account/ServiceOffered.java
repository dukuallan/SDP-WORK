package org.pahappa.systems.kimanyisacco.models.account;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "servicesOffereds")
@Inheritance(strategy = InheritanceType.JOINED)
public class ServiceOffered {
    private String service_id;
    private String service_name;
    private String service_amount;
    private Date service_date;

    @Id
    @GeneratedValue(generator = "serviceIdGenerator")
    @GenericGenerator(
            name = "serviceIdGenerator",
            strategy = "uuid"

    )
    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    @Column(name = "service_name")
    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    @Column(name = "service_amount")
    public String getService_amount() {
        return service_amount;
    }

    public void setService_amount(String service_amount) {
        this.service_amount = service_amount;
    }

    @Column(name = "service_date")
    public Date getService_date() {
        return service_date;
    }

    public void setService_date(Date service_date) {
        this.service_date = service_date;
    }
}
