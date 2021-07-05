package eu.senla.service;

import static java.time.temporal.ChronoUnit.DAYS;

import eu.senla.model.service.Service;
import java.time.LocalDate;
import java.util.TreeMap;

public class ServiceService {



  public int countServiceId(int lastUsedNumber) {
    int tempServiceId;
    tempServiceId = (int) Math.pow(2, lastUsedNumber);
    return tempServiceId;
  }

  public Service[] prepareCurrentServices(TreeMap<Integer, Service> services) {
    Service[] tempServiceArray = new Service[services.size()];
    for (int i = 0; i < services.size(); i++) {
      tempServiceArray[i] = services.get(countServiceId(i));
    }
    return tempServiceArray;
  }

  public Service selectServiceByCounter(TreeMap<Integer, Service> serviceList, int serviceCounter) {
    Service tempService = null;
    if (serviceList.containsKey(countServiceId(serviceCounter))) {
      tempService = serviceList.get(countServiceId(serviceCounter));
    }
    return tempService;
  }

  public Service selectAvailableServiceByName(TreeMap<Integer, Service> serviceList,
      String serviceName) {
    Service tempService = null;
    Service[] tempServiceArray = prepareCurrentServices(serviceList);
    for (Service service : tempServiceArray) {
      if (service.getName().toLowerCase().equals(serviceName.toLowerCase()) /*&& service
          .isAvailable()*/) {
        tempService = service;
        break;
      }
    }
    return tempService;
  }

  public Service selectServiceByName(TreeMap<Integer, Service> serviceList, String serviceName) {
    Service tempService = null;
    Service[] tempServiceArray = prepareCurrentServices(serviceList);
    for (Service service : tempServiceArray) {
      if (service.getName().toLowerCase().equals(serviceName.toLowerCase())) {
        tempService = service;
        break;
      }
    }
    return tempService;
  }

  public void changeServicePrice(TreeMap<Integer, Service> serviceList,
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

    public OrderedService(TreeMap<Integer, Service> serviceList, ServiceService serviceService,
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

    public OrderedService(TreeMap<Integer, Service> serviceList, ServiceService serviceService,
        int serviceNumber, LocalDate dateOfOrderingService, LocalDate dateOfEndingUseService) {
      this.orderedService = serviceService.selectServiceByCounter(serviceList, serviceNumber);
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