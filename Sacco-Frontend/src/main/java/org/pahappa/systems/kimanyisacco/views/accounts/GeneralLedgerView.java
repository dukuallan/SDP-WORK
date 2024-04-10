package org.pahappa.systems.kimanyisacco.views.accounts;

import org.pahappa.systems.kimanyisacco.models.GeneralLedger;
import org.pahappa.systems.kimanyisacco.services.impl.GeneralLedgerService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name ="generalLedgerView")
@ViewScoped
public class GeneralLedgerView {
    private List<GeneralLedger> dataModels;
    
    private GeneralLedgerService generalLedgerService;
    
    @PostConstruct
    public void init(){
        generalLedgerService = new GeneralLedgerService();
        getAllGeneralLedgerEntries();
    }
    
    public void getAllGeneralLedgerEntries(){
        dataModels = generalLedgerService.getAllGeneralLedgerEntries();
    }

    public List<GeneralLedger> getDataModels() {
        return dataModels;
    }

    public void setDataModels(List<GeneralLedger> dataModels) {
        this.dataModels = dataModels;
    }
}
