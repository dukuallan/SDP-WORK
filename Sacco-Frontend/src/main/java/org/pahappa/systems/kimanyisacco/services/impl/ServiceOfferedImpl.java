package org.pahappa.systems.kimanyisacco.services.impl;

import org.pahappa.systems.kimanyisacco.dao.ServiceOfferedDao;
import org.pahappa.systems.kimanyisacco.models.account.ServiceOffered;
import org.pahappa.systems.kimanyisacco.services.ServiceOfferedService;

import java.util.List;

public class ServiceOfferedImpl implements ServiceOfferedService {
    @Override
    public void createMember(ServiceOffered serviceOffered) {
        ServiceOfferedDao.save(serviceOffered);
    }

    @Override
    public List<ServiceOffered> displayAllServices() {
        return ServiceOfferedDao.getServiceOffered();
    }
}
