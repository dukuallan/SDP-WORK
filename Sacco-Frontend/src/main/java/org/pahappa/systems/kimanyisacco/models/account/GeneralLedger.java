package org.pahappa.systems.kimanyisacco.models.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "general_ledger")
public class GeneralLedger {
    private String description;
    private double amount;
    private Date transactionDate;
    private boolean reconciled;
    private double AmountLeft;

    private Long id;

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name = "transaction_date")
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Column(name = "reconciled")
    public boolean isReconciled() {
        return reconciled;
    }

    public void setReconciled(boolean reconciled) {
        this.reconciled = reconciled;
    }

    @Column(name = "amount_left")
    public double getAmountLeft() {
        return AmountLeft;
    }

    public void setAmountLeft(double amountLeft) {
        AmountLeft = amountLeft;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
