package eu.senla.service;

import java.util.TreeMap;

public class Services {

  protected final TreeMap<Integer, Service> services = new TreeMap<Integer, Service>() {
  };

  public Services() {
  }

  private int countServiceId(int lastUsedNumber) {
    int tempServiceId;
    tempServiceId = (int) Math.pow(2, lastUsedNumber);
    return tempServiceId;
  }

  public void addService(Service service) {
    service.setServiceId((countServiceId(services.size())));
    services.put(service.getServiceId(), service);
  }

  private Service[] prepareCurrentServices(TreeMap<Integer, Service> services) {
    Service[] tempServiceArray = new Service[services.size()];
    for (int i = 0; i < services.size(); i++) {
      tempServiceArray[i] = services.get(countServiceId(i));
    }
    return tempServiceArray;
  }

  public Service selectServiceByCounter(int serviceCounter) {
    Service tempService = null;

    if (services.containsKey(countServiceId(serviceCounter))) {
      tempService = services.get(countServiceId(serviceCounter));
    }
    return tempService;
  }

  public TreeMap<Integer, Service> getServices() {
    return services;
  }

  public Service selectServiceByName(String serviceName) {
    Service tempService = null;
    Service[] tempServiceArray = prepareCurrentServices(services);
    for (Service service : tempServiceArray) {
      if (service.getServiceName().toLowerCase().equals(serviceName.toLowerCase())) {
        tempService = service;
        break;
      }
    }
    return tempService;
  }
}
