package org.pahappa.systems.kimanyisacco.services.impl;

import org.pahappa.systems.kimanyisacco.dao.accountReconcilationDao.GeneralLedgerDao;
import org.pahappa.systems.kimanyisacco.models.account.GeneralLedger;

import java.util.List;

public class GeneralLedgerService {

    private GeneralLedgerDao generalLedgerDao = new GeneralLedgerDao();

    public List<GeneralLedger> getAllGeneralLedgerEntries(){
        return generalLedgerDao.getAllGeneralLedgerEntries();
    }
}
