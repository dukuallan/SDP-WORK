package org.pahappa.systems.kimanyisacco.services.impl;


import org.pahappa.systems.kimanyisacco.dao.accountReconcilationDao.AccountPayableDao;
import org.pahappa.systems.kimanyisacco.dao.accountReconcilationDao.GeneralLedgerDao;
import org.pahappa.systems.kimanyisacco.models.account.AccountPayable;
import org.pahappa.systems.kimanyisacco.models.account.GeneralLedger;
import org.pahappa.systems.kimanyisacco.services.ReconcilationStrategy;

import java.util.Date;
import java.util.List;


public class AccountsPayableReconcilation implements ReconcilationStrategy {
    
    private GeneralLedger generalLedger;

    private final GeneralLedgerDao generalLedgerDao= new GeneralLedgerDao();
    
    private final AccountPayableDao accountPayableDao = new AccountPayableDao();

    @Override
    public void reconcile(Object obj) {
        AccountPayable accountPayable = null;
        
        if (obj instanceof AccountPayable){
            accountPayable = (AccountPayable) obj;
        }

        Date paymentDate = accountPayable.getTransactionDate();
        double payableAmount = accountPayable.getAmount();
        String description = accountPayable.getDescription();

        generalLedger = new GeneralLedger();
        
        generalLedger.setAmount(payableAmount);
        generalLedger.setId(accountPayable.getId());
        generalLedger.setDescription(description);
        generalLedger.setReconciled(true);
        generalLedger.setTransactionDate(paymentDate);

        generalLedgerDao.saveToGeneralLedger(generalLedger);

        accountPayable.setReconciled(true);
        
        accountPayableDao.updateAccountPayable(accountPayable);
    }
    
    public void saveAccountPayable(AccountPayable accountPayable){
        accountPayableDao.saveToAccountPayable(accountPayable);
    }

    public List<AccountPayable> getAllAccountPayableEntries(){
        return accountPayableDao.getAllAccountPayableEntries();
    }
}
