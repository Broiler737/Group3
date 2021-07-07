package eu.senla.dao;

import eu.senla.model.service.Service;
import eu.senla.service.ServiceService;
import java.util.HashMap;

public class ServiceDao {

  final HashMap<Integer, Service> servicesList = new HashMap() {
  };


  public HashMap<Integer, Service> getServicesList() {
    return servicesList;
  }

  public void addService(ServiceService serviceService, String serviceName,
      Double servicePrice, String serviceType, Boolean perDay) {
       Service serviceToAdd = new Service(serviceName, servicePrice, serviceType, perDay);
    serviceToAdd.setId(countServiceId());
    getServicesList().put(serviceToAdd.getId(), serviceToAdd);
  }
  public int countServiceId( ) {
    int tempServiceId;
    tempServiceId = (int) Math.pow(2, getServicesList().size());
    return tempServiceId;
  }
  public static class s {

    public s() {
    }


  }
}
