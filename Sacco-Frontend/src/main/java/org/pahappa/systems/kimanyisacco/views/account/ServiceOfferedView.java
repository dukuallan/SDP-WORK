package org.pahappa.systems.kimanyisacco.views.account;

import org.pahappa.systems.kimanyisacco.models.account.ServiceOffered;
import org.pahappa.systems.kimanyisacco.services.ServiceOfferedService;
import org.pahappa.systems.kimanyisacco.services.impl.ServiceOfferedImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "serviceOffered")
@SessionScoped
public class ServiceOfferedView {
    private ServiceOffered serviceOffered;
    private ServiceOfferedService serviceOfferedService;

    @PostConstruct
    public void init() {
        serviceOffered = new ServiceOffered();
        serviceOfferedService = new ServiceOfferedImpl();
    }

    public ServiceOffered getServiceOffered() {
        return serviceOffered;
    }

    public void setServiceOffered(ServiceOffered serviceOffered) {
        this.serviceOffered = serviceOffered;
    }

    public ServiceOfferedService getServiceOfferedService() {
        return serviceOfferedService;
    }

    public void setServiceOfferedService(ServiceOfferedService serviceOfferedService) {
        this.serviceOfferedService = serviceOfferedService;
    }
}
