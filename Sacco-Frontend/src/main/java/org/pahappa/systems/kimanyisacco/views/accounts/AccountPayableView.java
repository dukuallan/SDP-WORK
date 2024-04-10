package org.pahappa.systems.kimanyisacco.views.accounts;



import org.pahappa.systems.kimanyisacco.models.AccountPayable;

import org.pahappa.systems.kimanyisacco.services.impl.AccountsPayableReconcilation;
import org.pahappa.systems.kimanyisacco.services.impl.ReconcilationManager;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "accountPayableView")
@SessionScoped
public class AccountPayableView {

    public AccountsPayableReconcilation getAccountsPayableReconcilation() {
        return accountsPayableReconcilation;
    }

    public void setAccountsPayableReconcilation(AccountsPayableReconcilation accountsPayableReconcilation) {
        this.accountsPayableReconcilation = accountsPayableReconcilation;
    }

    private AccountsPayableReconcilation accountsPayableReconcilation;

    public List<AccountPayable> getDataModels() {
        return dataModels;
    }

    public void setDataModels(List<AccountPayable> dataModels) {
        this.dataModels = dataModels;
    }

    private List<AccountPayable> dataModels;

    @PostConstruct
    public void init(){
        accountsPayableReconcilation = new AccountsPayableReconcilation();
        AccountPayable model = new AccountPayable();
        model.setDescription("Halo");
        model.setReconciled(false);
        model.setId(12356778L);
        System.out.println("We are saving the account payable");
        accountsPayableReconcilation.saveAccountPayable(model);
        getAllEntries();

    }

    public void getAllEntries(){
        dataModels = accountsPayableReconcilation.getAllAccountPayableEntries();
    }

    public void reconcileAccount(AccountPayable model){
        ReconcilationManager reconcilationManager = new ReconcilationManager();

        reconcilationManager.setReconcilationStrategy(new AccountsPayableReconcilation());

        reconcilationManager.reconcileAccount(model);
    }
}
