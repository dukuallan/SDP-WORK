package org.pahappa.systems.kimanyisacco.views.accounts;

import org.pahappa.systems.kimanyisacco.models.account.AccountReceivable;
import org.pahappa.systems.kimanyisacco.services.impl.AccountReceivableReconciliation;
import org.pahappa.systems.kimanyisacco.services.impl.ReconcilationManager;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "accountReceivableView")
@SessionScoped
public class AccountReceivableView {

    private AccountReceivableReconciliation accountReceivableReconciliation;

    private List<AccountReceivable> dataModels;

    @PostConstruct
    public void init(){
        /**
         * Here we are trying to put something in the table so that its created inorder to avoid the
         * table not being found when we try to display a table containing all accountReceivables
         */
        accountReceivableReconciliation = new AccountReceivableReconciliation();
        AccountReceivable model = new AccountReceivable();
        model.setDescription("Bruh");
        model.setReconciled(false);
        model.setId(12356779L);
        accountReceivableReconciliation.saveToAccountsReceivable(model);
        getAllEntries();

    }

    /**
     * This gets a list of all account receivables
     */
    public void getAllEntries(){
        dataModels = accountReceivableReconciliation.getAllAccountReceivableEntries();
    }

    /**
     * Here we are calling the reconcilation manager which helps us achieve the strategy pattern
     * @param model
     */
    public void reconcileAccount(AccountReceivable model){
        ReconcilationManager reconcilationManager = new ReconcilationManager();

        reconcilationManager.setReconcilationStrategy(new AccountReceivableReconciliation());

        reconcilationManager.reconcileAccount(model);
    }

    public List<AccountReceivable> getDataModels() {
        return dataModels;
    }

    public void setDataModels(List<AccountReceivable> dataModels) {
        this.dataModels = dataModels;
    }
}
