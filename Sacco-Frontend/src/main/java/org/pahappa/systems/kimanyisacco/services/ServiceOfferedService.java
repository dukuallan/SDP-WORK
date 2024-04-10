package org.pahappa.systems.kimanyisacco.services;

import org.pahappa.systems.kimanyisacco.models.account.ServiceOffered;

import java.util.List;

public interface ServiceOfferedService {
    void createMember(ServiceOffered serviceOffered);
    List<ServiceOffered> displayAllServices();
}
