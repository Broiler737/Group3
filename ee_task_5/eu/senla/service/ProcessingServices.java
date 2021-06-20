package eu.senla.service;

import eu.senla.dao.Services;
import eu.senla.model.service.Service;
import java.util.TreeMap;

public class ProcessingServices {

  private final Services services;

  public ProcessingServices(Services services) {
    this.services = services;
  }

  public int countServiceId(int lastUsedNumber) {
    int tempServiceId;
    tempServiceId = (int) Math.pow(2, lastUsedNumber);
    return tempServiceId;
  }

  public void addService(Service service) {
    service.setServiceId(countServiceId(services.getServices().size()));
    services.getServices().put(service.getServiceId(), service);
  }

  public Service[] prepareCurrentServices(TreeMap<Integer, Service> services) {
    Service[] tempServiceArray = new Service[services.size()];
    for (int i = 0; i < services.size(); i++) {
      tempServiceArray[i] = services.get(countServiceId(i));
    }
    return tempServiceArray;
  }

  public Service selectServiceByCounter(int serviceCounter) {
    Service tempService = null;

    if (services.getServices().containsKey(countServiceId(serviceCounter))) {
      tempService = services.getServices().get(countServiceId(serviceCounter));
    }
    return tempService;
  }

  public Service selectServiceByName(String serviceName) {
    Service tempService = null;
    Service[] tempServiceArray = prepareCurrentServices(services.getServices());
    for (Service service : tempServiceArray) {
      if (service.getServiceName().toLowerCase().equals(serviceName.toLowerCase()) && service
          .isAvailable()) {
        tempService = service;
        break;
      }
    }
    return tempService;
  }
}