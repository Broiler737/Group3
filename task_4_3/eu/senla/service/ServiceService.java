package eu.senla.service;

import static java.time.temporal.ChronoUnit.DAYS;

import eu.senla.dao.ServiceDao;
import eu.senla.model.service.Service;
import java.time.LocalDate;
import java.util.HashMap;

public class ServiceService {
  ServiceDao serviceDao;
  public ServiceService(ServiceDao serviceDao) {
    this.serviceDao=serviceDao;
  }

  public Service[] prepareCurrentServices() {
    Service[] tempServiceArray = new Service[serviceDao.getServicesList().size()];
    tempServiceArray = serviceDao.getServicesList().values().toArray(new Service[]{});
   /* for (int i = 0; i < tempServiceArray.length; i++) {
      tempServiceArray[i] = serviceDao.getServicesList().values().toArray().get(i);
    }*/
    return tempServiceArray;
  }

  public Service selectServiceByCounter(int serviceCounter) {
    Service tempService = null;
    if (serviceDao.getServicesList().containsKey(serviceCounter)) {
      tempService = serviceDao.getServicesList().get(serviceCounter);
    }
    return tempService;
  }

  public Service selectAvailableServiceByName(HashMap<Integer, Service> serviceList,
      String serviceName) {
    Service tempService = null;
    Service[] tempServiceArray = prepareCurrentServices();
    for (Service service : tempServiceArray) {
      if (service.getName().toLowerCase().equals(serviceName.toLowerCase()) /*&& service
          .isAvailable()*/) {
        tempService = service;
        break;
      }
    }
    return tempService;
  }

  public Service selectServiceByName(HashMap<Integer, Service> serviceList, String serviceName) {
    Service tempService = null;
    Service[] tempServiceArray = prepareCurrentServices();
    for (Service service : tempServiceArray) {
      if (service.getName().toLowerCase().equals(serviceName.toLowerCase())) {
        tempService = service;
        break;
      }
    }
    return tempService;
  }

  public void changeServicePrice(HashMap<Integer, Service> serviceList,
      ServiceService serviceService, String serviceName, Double servicePrice) {
    serviceService.selectServiceByName(serviceList, serviceName)
        .setPrice(servicePrice);
    System.out.println("Now " + serviceName + " price is " + servicePrice + "$");
  }

  public static class OrderedService {

    final Service orderedService;
    final LocalDate dateOfOrderingService;
    final LocalDate dateOfEndingUseService;
    int durationOfUseService;
    int countOfOrderingService;

    public OrderedService(HashMap<Integer, Service> serviceList, ServiceService serviceService,
        String serviceName, LocalDate dateOfOrderingService, LocalDate dateOfEndingUseService) {

      Service tempService = serviceService.selectAvailableServiceByName(serviceList, serviceName);
      this.orderedService = tempService;
      this.dateOfOrderingService = dateOfOrderingService;
      this.dateOfEndingUseService = dateOfEndingUseService;
      if (tempService.isPerDay()) {
        this.durationOfUseService = (int) DAYS
            .between(dateOfOrderingService, dateOfEndingUseService);
        this.countOfOrderingService = 0;
      } else {
        this.countOfOrderingService = 1;
        this.durationOfUseService = 0;
      }
    }

    public OrderedService(HashMap<Integer, Service> serviceList, ServiceService serviceService,
        int serviceNumber, LocalDate dateOfOrderingService, LocalDate dateOfEndingUseService) {
      this.orderedService = serviceService.selectServiceByCounter(serviceNumber);
      this.dateOfOrderingService = dateOfOrderingService;
      this.dateOfEndingUseService = dateOfEndingUseService;
      this.durationOfUseService = (int) DAYS.between(dateOfOrderingService, dateOfEndingUseService);
    }

    public LocalDate getDateOfOrderingService() {
      return dateOfOrderingService;
    }

    public LocalDate getDateOfEndingUseService() {
      return dateOfEndingUseService;
    }

    public int getDurationOfUseService() {
      return durationOfUseService;
    }

    public int getCountOfOrderingService() {
      return countOfOrderingService;
    }

    public void setCountOfOrderingService(int countOfOrderingService) {
      this.countOfOrderingService = countOfOrderingService;
    }

    public void setDurationOfUseService(int durationOfUseService) {
      this.durationOfUseService = durationOfUseService;
    }

    public Service getOrderedService() {
      return orderedService;
    }
  }
}