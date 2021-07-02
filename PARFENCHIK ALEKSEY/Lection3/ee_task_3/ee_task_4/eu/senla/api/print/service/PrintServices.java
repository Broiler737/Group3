package eu.senla.api.print.service;

import eu.senla.model.guest.Guest;
import eu.senla.model.hotel.Hotel;
import eu.senla.model.service.Service;
import eu.senla.service.ServiceService.OrderedService;
import eu.senla.utils.comparator.service.ComparatorOrderedServiceByNameAscending;
import eu.senla.utils.comparator.service.ComparatorOrderedServiceByPriceAscending;
import eu.senla.utils.comparator.service.ComparatorOrderedServiceByPriceDescending;
import eu.senla.utils.comparator.service.ComparatorServiceByNameAscending;
import eu.senla.utils.comparator.service.ComparatorServiceByPriceAscending;
import eu.senla.utils.comparator.service.ComparatorServiceByPriceDescending;
import eu.senla.utils.comparator.service.ComparatorServiceByTypeAscending;
import java.util.Arrays;

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

  public void printGuestServicesByNameAscending(Hotel hotelInformationToPrint, int guestHash) {
    Guest guestToPrint = hotelInformationToPrint.getGuestService()
        .findGuestByHash(hotelInformationToPrint, guestHash);
    OrderedService[] tempServicesArrayToPrint = guestToPrint.getOrderedServices().toArray(
        new OrderedService[]{});
    Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
        new ComparatorOrderedServiceByNameAscending());
    if (!guestToPrint.getOrderedServices().isEmpty()) {
      System.out
          .println("The guest " + guestToPrint.getName() + " has ordered these services:");
      for (OrderedService orderedService : tempServicesArrayToPrint) {
        hotelInformationToPrint.printInformation.getPrintServices()
            .printServiceSimple(orderedService.getOrderedService());
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

  public void printGuestServicesByNameDescending(Hotel hotelInformationToPrint,
      int guestHash) {
    Guest guestToPrint = hotelInformationToPrint.getGuestService()
        .findGuestByHash(hotelInformationToPrint, guestHash);
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
          .println("The guest " + guestToPrint.getName() + " has ordered these services:");
      for (OrderedService orderedService : tempServicesToPrintReverseArray) {
        hotelInformationToPrint.printInformation.getPrintServices()
            .printServiceSimple(orderedService.getOrderedService());
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

  public void printGuestServicesByPriceAscending(Hotel hotelInformationToPrint,
      Guest guestToPrint) {
    if (!guestToPrint.getOrderedServices().isEmpty()) {
      OrderedService[] tempServicesArrayToPrint = guestToPrint.getOrderedServices().toArray(
          new OrderedService[]{});
      Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
          new ComparatorOrderedServiceByPriceAscending());
      System.out
          .println("The guest " + guestToPrint.getName() + " has ordered these services:");
      for (OrderedService orderedService : tempServicesArrayToPrint) {
        hotelInformationToPrint.printInformation.getPrintServices()
            .printServiceSimple(orderedService.getOrderedService());
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

  public void printGuestServicesByPriceDescending(Hotel hotelInformationToPrint,
      Guest guestToPrint) {
    if (!guestToPrint.getOrderedServices().isEmpty()) {
      OrderedService[] tempServicesArrayToPrint = guestToPrint.getOrderedServices().toArray(
          new OrderedService[]{});
      Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
          new ComparatorOrderedServiceByPriceDescending());
      System.out
          .println("The guest " + guestToPrint.getName() + " has ordered these services:");
      for (OrderedService orderedService : tempServicesArrayToPrint) {
        hotelInformationToPrint.printInformation.getPrintServices()
            .printServiceSimple(orderedService.getOrderedService());
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


  public void printGuestByNameServicesByPriceAscending(Hotel hotelInformationToPrint,
      String guestName) {
    Guest tempGuest = hotelInformationToPrint.getGuestService()
        .selectGuestByName(hotelInformationToPrint, guestName);
    OrderedService[] tempServicesArrayToPrint = tempGuest.getOrderedServices().toArray(
        new OrderedService[]{});
    Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
        new ComparatorOrderedServiceByPriceAscending());
    if (!tempGuest.getOrderedServices().isEmpty()) {
      System.out.println("The guest " + tempGuest.getName() + " has ordered these services:");
      for (OrderedService orderedService : tempServicesArrayToPrint) {
        hotelInformationToPrint.printInformation.getPrintServices()
            .printServiceSimple(orderedService.getOrderedService());
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

  public void printGuestByNameServicesByPriceDescending(Hotel hotelInformationToPrint,
      String guestName) {
    Guest tempGuest = hotelInformationToPrint.getGuestService()
        .selectGuestByName(hotelInformationToPrint, guestName);
    OrderedService[] tempServicesArrayToPrint = tempGuest.getOrderedServices().toArray(
        new OrderedService[]{});
    Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
        new ComparatorOrderedServiceByPriceDescending());
    if (!tempGuest.getOrderedServices().isEmpty()) {
      System.out.println("The guest " + tempGuest.getName() + " has ordered these services:");
      for (OrderedService orderedService : tempServicesArrayToPrint) {
        hotelInformationToPrint.printInformation.getPrintServices()
            .printServiceSimple(orderedService.getOrderedService());
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

  public void printServicesByNameAscending(Hotel hotelInformationToPrint) {
    hotelInformationToPrint.getServiceService()
        .prepareCurrentServices(hotelInformationToPrint.getServicesDao().getServicesList());
    Service[] tempServiceArray = hotelInformationToPrint.getServiceService()
        .prepareCurrentServices(hotelInformationToPrint.getServicesDao().getServicesList());
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByNameAscending());
    for (Service sortedService : tempServiceArray) {
      hotelInformationToPrint.printInformation.getPrintServices()
          .printServiceDetails(sortedService);
      System.out.println();
    }
  }

  public void printServicesByNameDescending(Hotel hotelInformationToPrint) {
    Service[] tempServiceArray = hotelInformationToPrint.getServiceService()
        .prepareCurrentServices(hotelInformationToPrint.getServicesDao().getServicesList());
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByNameAscending());
    for (int i = 0; i < tempServiceArray.length; i++) {
      hotelInformationToPrint.printInformation.getPrintServices()
          .printServiceDetails(tempServiceArray[tempServiceArray.length - 1 - i]);
    }
  }

  public void printServicesByPriceAscending(Hotel hotelInformationToPrint) {
    Service[] tempServiceArray = hotelInformationToPrint.getServiceService()
        .prepareCurrentServices(hotelInformationToPrint.getServicesDao().getServicesList());
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByPriceAscending());
    for (Service sortedService : tempServiceArray) {
      hotelInformationToPrint.printInformation.getPrintServices()
          .printServiceDetails(sortedService);
      System.out.println();
    }
  }

  public void printServicesByPriceDescending(Hotel hotelInformationToPrint) {
    Service[] tempServiceArray = hotelInformationToPrint.getServiceService()
        .prepareCurrentServices(hotelInformationToPrint.getServicesDao().getServicesList());
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByPriceDescending());
    for (Service sortedService : tempServiceArray) {
      hotelInformationToPrint.printInformation.getPrintServices()
          .printServiceDetails(sortedService);
      System.out.println();
    }
  }

  public void printServicesByTypeAscending(Hotel hotelInformationToPrint) {
    hotelInformationToPrint.getServiceService()
        .prepareCurrentServices(hotelInformationToPrint.getServicesDao().getServicesList());
    Service[] tempServiceArray = hotelInformationToPrint.getServiceService()
        .prepareCurrentServices(hotelInformationToPrint.getServicesDao().getServicesList());
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByTypeAscending());
    for (Service sortedService : tempServiceArray) {
      hotelInformationToPrint.printInformation.getPrintServices()
          .printServiceDetails(sortedService);
      System.out.println();
    }
  }

  public void printServicesByTypeDescending(Hotel hotelInformationToPrint) {
    hotelInformationToPrint.getServiceService()
        .prepareCurrentServices(hotelInformationToPrint.getServicesDao().getServicesList());
    Service[] tempServiceArray = hotelInformationToPrint.getServiceService()
        .prepareCurrentServices(hotelInformationToPrint.getServicesDao().getServicesList());
    Service[] tempServiceReverseArray = new Service[tempServiceArray.length];
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByTypeAscending());
    for (int i = 0; i < tempServiceArray.length; i++) {
      tempServiceReverseArray[i] = tempServiceArray[tempServiceArray.length - 1 - i];
    }
    for (Service sortedService : tempServiceReverseArray) {
      hotelInformationToPrint.printInformation.getPrintServices()
          .printServiceDetails(sortedService);
      System.out.println();
    }
  }
}
