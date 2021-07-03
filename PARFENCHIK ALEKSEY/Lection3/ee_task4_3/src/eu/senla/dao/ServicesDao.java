package eu.senla.dao;

import eu.senla.model.service.Service;
import eu.senla.service.ServiceService;
import java.util.TreeMap;

public class ServicesDao {

  final TreeMap<Integer, Service> servicesList = new TreeMap() {
  };

  public TreeMap<Integer, Service> getServicesList() {
    return servicesList;
  }

  public void addService(ServiceService serviceService, String serviceName,
      Double servicePrice, String serviceType, Boolean perDay) {
    Service serviceToAdd = new Service(serviceName, servicePrice, serviceType, perDay);
    serviceToAdd.setId(serviceService.countServiceId(getServicesList().size()));
    getServicesList().put(serviceToAdd.getId(), serviceToAdd);
  }
}
