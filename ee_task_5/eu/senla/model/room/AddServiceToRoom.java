package eu.senla.model.room;

import eu.senla.model.hotel.Hotel;
import eu.senla.model.service.Service;

public class AddServiceToRoom {

  private final Room room;

  public AddServiceToRoom(Room room) {
    this.room = room;
  }

  public void addServiceByName(String serviceName, Hotel hotel) {
    Service serviceToAdd;
    serviceToAdd = hotel.getProcessingServices().selectServiceByName(serviceName);
    room.getRoomServices().putIfAbsent(serviceToAdd.getServiceId(), serviceToAdd);
    System.out.println("Service has successful added to room #" + room.getRoomNumber());
    System.out.println("Information about service below:");
    hotel.printInformation.getPrintServiceDetails().printServiceDetails(serviceToAdd);
  }

  public void addServiceByCounter(int serviceCounter, Hotel hotel) {
    Service serviceToAdd;
    serviceToAdd = hotel.getProcessingServices().selectServiceByCounter(serviceCounter);
    room.getRoomServices().putIfAbsent(serviceToAdd.getServiceId(), serviceToAdd);
    System.out.println("Service has successful added to room #" + room.getRoomNumber());
    System.out.println("Information about service below:");
    hotel.printInformation.getPrintServiceDetails().printServiceDetails(serviceToAdd);
  }
}