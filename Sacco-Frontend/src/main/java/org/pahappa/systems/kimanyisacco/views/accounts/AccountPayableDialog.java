package org.pahappa.systems.kimanyisacco.views.accounts;


import org.pahappa.systems.kimanyisacco.models.AccountPayable;
import org.pahappa.systems.kimanyisacco.services.impl.AccountsPayableReconcilation;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "accountPayableDialog")
public class AccountPayableDialog {
    private AccountsPayableReconcilation accountsPayableReconcilation;

    public AccountPayableDialog() {
//        super(HyperLinks.ACCOUNT_PAYABLE_DIALOG, 700, 300);
    }

    @PostConstruct
    public void init(){
//        super.model = new AccountPayable();
        accountsPayableReconcilation = new AccountsPayableReconcilation();
    }

    public void persist() throws Exception {
        AccountPayable model = new AccountPayable();
        model.setDescription("Alright");
        model.setReconciled(false);
        model.setId(12356775L);
        accountsPayableReconcilation.saveAccountPayable(model);

    }

//    public void resetModal(){
//        super.resetModal();
//        super.model = new AccountPayable();
//    }
}
