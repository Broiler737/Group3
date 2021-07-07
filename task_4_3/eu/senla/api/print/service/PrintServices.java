package eu.senla.api.print.service;

import eu.senla.model.guest.Guest;
import eu.senla.model.room.Room;
import eu.senla.model.service.Service;
import eu.senla.service.GuestService;
import eu.senla.service.ServiceService;
import eu.senla.service.ServiceService.OrderedService;
import eu.senla.utils.comparator.service.ComparatorOrderedServiceByNameAscending;
import eu.senla.utils.comparator.service.ComparatorOrderedServiceByPriceAscending;
import eu.senla.utils.comparator.service.ComparatorOrderedServiceByPriceDescending;
import eu.senla.utils.comparator.service.ComparatorServiceByNameAscending;
import eu.senla.utils.comparator.service.ComparatorServiceByPriceAscending;
import eu.senla.utils.comparator.service.ComparatorServiceByPriceDescending;
import eu.senla.utils.comparator.service.ComparatorServiceByTypeAscending;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class PrintServices {

  public void printServiceDetails(Service service) {
    System.out.println("    Service ID " + service.getId());
    System.out.println("    Service name: " + service.getName());
    System.out.println("    Service type: " + service.getType());
    if (service.isPerDay()) {
      System.out.println("    Service price is " + service.getPrice() + "S per day");
    } else {
      System.out.println("    Service price is " + service.getPrice() + "S one time");
    }
  }

  public void printServiceSimple(Service service) {
    System.out.println("    Service name: " + service.getName());
    if (service.isPerDay()) {
      System.out.println("    Service price is " + service.getPrice() + "S per day");
    } else {
      System.out.println("    Service price is " + service.getPrice() + "S one time");
    }
  }

  public void printGuestServicesByNameAscending(GuestService guestService, List<Room> roomList,
      int guestHash) {
    Guest guestToPrint = guestService
        .findGuestByHash(roomList, guestHash);
    OrderedService[] tempServicesArrayToPrint = guestToPrint.getOrderedServices().toArray(
        new OrderedService[]{});
    Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
        new ComparatorOrderedServiceByNameAscending());
    if (!guestToPrint.getOrderedServices().isEmpty()) {
      System.out
          .println("The guest " + guestToPrint.getFullName() + " has ordered these services:");
      for (OrderedService orderedService : tempServicesArrayToPrint) {
        printServiceSimple(orderedService.getOrderedService());
        System.out.println(
            "This service guest has ordered " + orderedService.getDateOfOrderingService()
                + ",");
        if (orderedService.getOrderedService().isPerDay()) {
          System.out
              .println(
                  "and use it till " + orderedService.getDateOfEndingUseService());
        } else {
          System.out
              .println(
                  "and use it " + orderedService.getCountOfOrderingService() + " times");
        }
        System.out.println();
      }
      System.out.println("******** End list of ordered services");
      System.out.println();
    } else {
      System.out.println("Guest haven't ordered any service");
    }
  }

  public void printGuestServicesByNameDescending(GuestService guestService, List<Room> roomList,
      int guestHash) {
    Guest guestToPrint = guestService
        .findGuestByHash(roomList, guestHash);
    OrderedService[] tempServicesArrayToPrint = guestToPrint.getOrderedServices().toArray(
        new OrderedService[]{});
    Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
        new ComparatorOrderedServiceByNameAscending());
    if (!guestToPrint.getOrderedServices().isEmpty()) {
      OrderedService[] tempServicesToPrintReverseArray = new OrderedService[tempServicesArrayToPrint
          .length];
      for (int i = 0; i < tempServicesArrayToPrint.length; i++) {
        tempServicesToPrintReverseArray[i] = tempServicesArrayToPrint[
            tempServicesToPrintReverseArray.length - 1 - i];
      }
      System.out.println();
      System.out
          .println("The guest " + guestToPrint.getFullName() + " has ordered these services:");
      for (OrderedService orderedService : tempServicesToPrintReverseArray) {
        printServiceSimple(orderedService.getOrderedService());
        System.out.println(
            "This service guest has ordered "
                + orderedService.getDateOfOrderingService()
                + ",");
        if (orderedService.getOrderedService().isPerDay()) {
          System.out
              .println(
                  "and use it till " + orderedService.getDateOfEndingUseService());
        } else {
          System.out
              .println(
                  "and use it " + orderedService.getCountOfOrderingService()
                      + " times");
        }
        System.out.println();
      }
      System.out.println("******** End list of ordered services");
      System.out.println();

    } else {
      System.out.println("Guest haven't ordered any service");
    }
  }

  public void printGuestServicesByPriceAscending(Guest guestToPrint) {
    if (!guestToPrint.getOrderedServices().isEmpty()) {
      OrderedService[] tempServicesArrayToPrint = guestToPrint.getOrderedServices().toArray(
          new OrderedService[]{});
      Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
          new ComparatorOrderedServiceByPriceAscending());
      System.out
          .println("The guest " + guestToPrint.getFullName() + " has ordered these services:");
      for (OrderedService orderedService : tempServicesArrayToPrint) {
        printServiceSimple(orderedService.getOrderedService());
        System.out.println(
            "This service guest has ordered " + orderedService.getDateOfOrderingService()
                + ",");
        if (orderedService.getOrderedService().isPerDay()) {
          System.out
              .println(
                  "and use it till " + orderedService.getDateOfEndingUseService());
        } else {
          System.out
              .println(
                  "and use it " + orderedService.getCountOfOrderingService() + " times");
        }
        System.out.println();
      }
      System.out.println("******** End list of ordered services");
      System.out.println();
    } else {
      System.out.println("Guest haven't ordered any service");
    }
  }

  public void printGuestServicesByPriceDescending(Guest guestToPrint) {
    if (!guestToPrint.getOrderedServices().isEmpty()) {
      OrderedService[] tempServicesArrayToPrint = guestToPrint.getOrderedServices().toArray(
          new OrderedService[]{});
      Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
          new ComparatorOrderedServiceByPriceDescending());
      System.out
          .println("The guest " + guestToPrint.getFullName() + " has ordered these services:");
      for (OrderedService orderedService : tempServicesArrayToPrint) {
        printServiceSimple(orderedService.getOrderedService());
        System.out.println(
            "This service guest has ordered " + orderedService.getDateOfOrderingService()
                + ",");
        if (orderedService.getOrderedService().isPerDay()) {
          System.out
              .println(
                  "and use it till " + orderedService.getDateOfEndingUseService());
        } else {
          System.out
              .println(
                  "and use it " + orderedService.getCountOfOrderingService() + " times");
        }
        System.out.println();
      }
      System.out.println("******** End list of ordered services");
      System.out.println();
    } else {
      System.out.println("Guest haven't ordered any service");
    }
  }


  public void printGuestByNameServicesByPriceAscending(GuestService guestService,
      List<Room> roomList, String guestName) {
    Guest tempGuest = guestService
        .selectGuestByName(roomList, guestName);
    OrderedService[] tempServicesArrayToPrint = tempGuest.getOrderedServices().toArray(
        new OrderedService[]{});
    Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
        new ComparatorOrderedServiceByPriceAscending());
    if (!tempGuest.getOrderedServices().isEmpty()) {
      System.out.println("The guest " + tempGuest.getFullName() + " has ordered these services:");
      for (OrderedService orderedService : tempServicesArrayToPrint) {
        printServiceSimple(orderedService.getOrderedService());
        System.out.println(
            "This service guest has ordered " + orderedService.getDateOfOrderingService()
                + ",");
        if (orderedService.getOrderedService().isPerDay()) {
          System.out
              .println(
                  "and use it till " + orderedService.getDateOfEndingUseService());
        } else {
          System.out
              .println(
                  "and use it " + orderedService.getCountOfOrderingService() + " times");
        }
        System.out.println();
      }
      System.out.println("******** End list of ordered services");
      System.out.println();
    } else {
      System.out.println("Guest haven't ordered any service");
    }
  }

  public void printGuestByNameServicesByPriceDescending(GuestService guestService,
      List<Room> roomList, String guestName) {
    Guest tempGuest = guestService
        .selectGuestByName(roomList, guestName);
    OrderedService[] tempServicesArrayToPrint = tempGuest.getOrderedServices().toArray(
        new OrderedService[]{});
    Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
        new ComparatorOrderedServiceByPriceDescending());
    if (!tempGuest.getOrderedServices().isEmpty()) {
      System.out.println("The guest " + tempGuest.getFullName() + " has ordered these services:");
      for (OrderedService orderedService : tempServicesArrayToPrint) {
        printServiceSimple(orderedService.getOrderedService());
        System.out.println(
            "This service guest has ordered " + orderedService.getDateOfOrderingService()
                + ",");
        if (orderedService.getOrderedService().isPerDay()) {
          System.out
              .println(
                  "and use it till " + orderedService.getDateOfEndingUseService());
        } else {
          System.out
              .println(
                  "and use it " + orderedService.getCountOfOrderingService() + " times");
        }
        System.out.println();
      }
      System.out.println("******** End list of ordered services");
      System.out.println();
    } else {
      System.out.println("Guest haven't ordered any service");
    }
  }

  public void printServicesByNameAscending(ServiceService serviceService,
      HashMap<Integer, Service> servicesList) {
    serviceService
        .prepareCurrentServices();
    Service[] tempServiceArray = serviceService
        .prepareCurrentServices();
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByNameAscending());
    for (Service sortedService : tempServiceArray) {
      printServiceDetails(sortedService);
    }
  }

  public void printServicesByNameDescending(ServiceService serviceService,
      HashMap<Integer, Service> servicesList) {
    serviceService
        .prepareCurrentServices();
    Service[] tempServiceArray = serviceService
        .prepareCurrentServices();
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByNameAscending());
    ;
    for (int i = 0; i < tempServiceArray.length; i++) {
      printServiceDetails(tempServiceArray[tempServiceArray.length - 1 - i]);
    }
  }

  public void printServicesByPriceAscending(ServiceService serviceService,
      HashMap<Integer, Service> servicesList) {
    Service[] tempServiceArray = serviceService
        .prepareCurrentServices();
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByPriceAscending());
    for (Service sortedService : tempServiceArray) {
      printServiceDetails(sortedService);
    }
  }

  public void printServicesByPriceDescending(ServiceService serviceService,
      HashMap<Integer, Service> servicesList) {
    Service[] tempServiceArray = serviceService
        .prepareCurrentServices();
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByPriceDescending());
    for (Service sortedService : tempServiceArray) {
      printServiceDetails(sortedService);

    }
  }

  public void printServicesByTypeAscending(ServiceService serviceService,
      HashMap<Integer, Service> servicesList) {
    Service[] tempServiceArray = serviceService
        .prepareCurrentServices();
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByTypeAscending());
    for (Service sortedService : tempServiceArray) {
      printServiceDetails(sortedService);

    }
  }

  public void printServicesByTypeDescending(ServiceService serviceService,
      HashMap<Integer, Service> servicesList) {
    Service[] tempServiceArray = serviceService
        .prepareCurrentServices();
    Service[] tempServiceReverseArray = new Service[tempServiceArray.length];
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByTypeAscending());
    for (int i = 0; i < tempServiceArray.length; i++) {
      tempServiceReverseArray[i] = tempServiceArray[tempServiceArray.length - 1 - i];
    }
    for (Service sortedService : tempServiceReverseArray) {
      printServiceDetails(sortedService);
    }
  }
}
