package org.pahappa.systems.kimanyisacco.services.impl;

import org.pahappa.systems.kimanyisacco.dao.accountReconcilationDao.AccountReceivableDao;
import org.pahappa.systems.kimanyisacco.dao.accountReconcilationDao.GeneralLedgerDao;
import org.pahappa.systems.kimanyisacco.models.AccountReceivable;
import org.pahappa.systems.kimanyisacco.models.GeneralLedger;
import org.pahappa.systems.kimanyisacco.services.ReconcilationStrategy;

import java.util.Date;
import java.util.List;

public class AccountReceivableReconciliation implements ReconcilationStrategy {
    private GeneralLedger generalLedger;

    private final GeneralLedgerDao generalLedgerDao= new GeneralLedgerDao();

    private final AccountReceivableDao accountReceivableDao = new AccountReceivableDao();

    @Override
    public void reconcile(Object obj) {
        AccountReceivable accountReceivable = null;

        if (obj instanceof AccountReceivable){
            accountReceivable = (AccountReceivable) obj;
        }

        Date paymentDate = accountReceivable.getTransactionDate();
        double payableAmount = accountReceivable.getAmount();
        String description = accountReceivable.getDescription();

        generalLedger = new GeneralLedger();

        generalLedger.setAmount(payableAmount);
        generalLedger.setId(accountReceivable.getId());
        generalLedger.setDescription(description);
        generalLedger.setReconciled(true);
        generalLedger.setTransactionDate(paymentDate);

        generalLedgerDao.saveToGeneralLedger(generalLedger);

        accountReceivable.setReconciled(true);

        accountReceivableDao.updateAccountReceivable(accountReceivable);
    }

    public void saveToAccountsReceivable(AccountReceivable accountReceivable){
        accountReceivableDao.saveToAccountReceivable(accountReceivable);
    }

    public List<AccountReceivable> getAllAccountReceivableEntries(){
        return accountReceivableDao.getAllAccountReceivableEntries();
    }
}
