package eu.senla.service;

import static java.time.temporal.ChronoUnit.DAYS;

import eu.senla.dao.ServicesDao;
import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;
import eu.senla.model.service.Service;
import java.time.LocalDate;
import java.util.TreeMap;

public class ServiceService {

  private final ServicesDao servicesDao;

  public ServiceService(ServicesDao servicesDao) {
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

  public Service selectAvailableServiceByName(String serviceName) {
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

  public Service selectServiceByName(String serviceName) {
    Service tempService = null;
    Service[] tempServiceArray = prepareCurrentServices(servicesDao.getServicesList());
    for (Service service : tempServiceArray) {
      if (service.getServiceName().toLowerCase().equals(serviceName.toLowerCase())) {
        tempService = service;
        break;
      }
    }
    return tempService;
  }

  /*public void addServiceToRoomByName(Hotel hotel, Room room, String serviceName) {
    Service serviceToAdd;
    serviceToAdd = hotel.getServiceService().selectAvailableServiceByName(serviceName);
    room.getRoomServices().putIfAbsent(serviceToAdd.getServiceId(), serviceToAdd);
    System.out.println("Service has successful added to room #" + room.getRoomNumber());
    System.out.println("Information about service below:");
    hotel.printInformation.getPrintServices().printServiceDetails(serviceToAdd);
  }*/

  /*public void addServiceToRoomByCounter(Hotel hotel, Room room, int serviceCounter) {
    Service serviceToAdd;
    serviceToAdd = hotel.getServiceService().selectServiceByCounter(serviceCounter);
    room.getRoomServices().putIfAbsent(serviceToAdd.getServiceId(), serviceToAdd);
    System.out.println("Service has successful added to room #" + room.getRoomNumber());
    System.out.println("Information about service below:");
    hotel.printInformation.getPrintServices().printServiceDetails(serviceToAdd);
  }*/

  public void changeServicePrice(Hotel hotel, String serviceName, Double servicePrice) {
    hotel.getServiceService().selectServiceByName(serviceName)
        .setServicePrice(servicePrice);
    System.out.println("Now " + serviceName + " price is " + servicePrice + "$");
  }

  public void changeServiceAvailability(Hotel hotel, String serviceName) {
    hotel.getServiceService().selectServiceByName(serviceName).setAvailable(
        !hotel.getServiceService().selectServiceByName(serviceName).isAvailable());
    if (hotel.getServiceService().selectServiceByName(serviceName).isAvailable()) {
      System.out.println(
          "Now service " + hotel.getServiceService().selectServiceByName(serviceName).getServiceName()
              + " is available");
    } else {
      System.out.println(
          "Now service " + hotel.getServiceService().selectServiceByName(serviceName).getServiceName()
              + " is not available");
    }
  }

  public static class OrderedService {

    final Service orderedService;
    final LocalDate dateOfOrderingService;
    final LocalDate dateOfEndingUseService;
    int durationOfUseService;
    int countOfOrderingService;

    public OrderedService(Hotel informationToProcessing, String serviceName,
                          LocalDate dateOfOrderingService, LocalDate dateOfEndingUseService) {
      Service tempService = informationToProcessing.getServiceService().selectAvailableServiceByName(serviceName);
      this.orderedService = tempService;
      this.dateOfOrderingService = dateOfOrderingService;
      this.dateOfEndingUseService = dateOfEndingUseService;
      if (tempService.isPerDay()) {
        this.durationOfUseService = (int) DAYS.between(dateOfOrderingService, dateOfEndingUseService);
        this.countOfOrderingService = 0;
      } else {
        this.countOfOrderingService = 1;
        this.durationOfUseService = 0;
      }
    }

    public OrderedService(Hotel informationToProcessing, int serviceNumber,
        LocalDate dateOfOrderingService, LocalDate dateOfEndingUseService) {
      this.orderedService = informationToProcessing.getServiceService().selectServiceByCounter(serviceNumber);
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