package org.pahappa.systems.kimanyisacco.models.account;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
@Inheritance(strategy = InheritanceType.JOINED)
public class Invoice {
    private String invoiceId;
    private double amount;
    private Date dateCreated;
    private List<ServiceOffered> offeredList;

    @Id
    @GeneratedValue(generator = "sequenceGenerator")
    @GenericGenerator(
            name = "sequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "Invoice_001"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Column(name = "total_amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name = "date_of_creation")
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "invoice")
    public List<ServiceOffered> getOfferedList() {
        return offeredList;
    }

    public void setOfferedList(List<ServiceOffered> offeredList) {
        this.offeredList = offeredList;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                ", amount=" + amount +
                ", dateCreated=" + dateCreated +
                ", offeredList=" + offeredList +
                '}';
    }
}
