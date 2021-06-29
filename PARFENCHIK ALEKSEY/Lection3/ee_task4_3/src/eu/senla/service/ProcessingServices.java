package eu.senla.service;

import eu.senla.dao.ServicesDao;
import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;
import eu.senla.model.service.Service;
import java.util.TreeMap;

public class ProcessingServices {

  private final ServicesDao servicesDao;

  public ProcessingServices(ServicesDao servicesDao) {
    this.servicesDao = servicesDao;
  }

  public int countServiceId(int lastUsedNumber) {
    int tempServiceId;
    tempServiceId = (int) Math.pow(2, lastUsedNumber);
    return tempServiceId;
  }

  public void addService(Service service) {
    service.setServiceId(countServiceId(servicesDao.getServicesList().size()));
    servicesDao.getServicesList().put(service.getServiceId(), service);
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

    if (servicesDao.getServicesList().containsKey(countServiceId(serviceCounter))) {
      tempService = servicesDao.getServicesList().get(countServiceId(serviceCounter));
    }
    return tempService;
  }

  public Service selectServiceByName(String serviceName) {
    Service tempService = null;
    Service[] tempServiceArray = prepareCurrentServices(servicesDao.getServicesList());
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