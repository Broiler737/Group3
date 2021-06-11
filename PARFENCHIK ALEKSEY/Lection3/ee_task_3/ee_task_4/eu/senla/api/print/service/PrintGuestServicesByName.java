package eu.senla.api.print.service;

import eu.senla.guest.Guest;
import eu.senla.guest.OrderedService;
import eu.senla.hotel.Hotel;
import eu.senla.utils.comparator.service.ComparatorOrderedServiceByNameAscending;
import java.util.Arrays;

public class PrintGuestServicesByName {

  public void printGuestServicesByNameAscending(Hotel hotelInformationToPrint, Guest guestToPrint) {
    OrderedService[] tempServicesArrayToPrint = guestToPrint.getOrderedServices().toArray(
        new OrderedService[]{});
    Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
        new ComparatorOrderedServiceByNameAscending());
    if (!guestToPrint.getOrderedServices().isEmpty()) {
      System.out
          .println("The guest " + guestToPrint.getGuestName() + " has ordered these services:");
      for (OrderedService orderedService : tempServicesArrayToPrint) {
        hotelInformationToPrint.printInformation.getPrintServiceDetails()
            .printServiceSimple(orderedService.getOrderedService());
        System.out.println(
            "This service guest has ordered " + orderedService.getCountOfOrderingService()
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
      Guest guestToPrint) {
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
          .println("The guest " + guestToPrint.getGuestName() + " has ordered these services:");
      for (OrderedService orderedService : tempServicesToPrintReverseArray) {
        hotelInformationToPrint.printInformation.getPrintServiceDetails()
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


  public void printGuestByNameServicesByNameAscending(Hotel hotelInformationToPrint,
      String guestName) {
    Guest tempGuest = hotelInformationToPrint.getGuestInRoom(hotelInformationToPrint, guestName);
    OrderedService[] tempServicesArrayToPrint = tempGuest.getOrderedServices().toArray(
        new OrderedService[]{});
    Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
        new ComparatorOrderedServiceByNameAscending());
    if (!tempGuest.getOrderedServices().isEmpty()) {
      System.out.println("The guest " + tempGuest.getGuestName() + " has ordered these services:");
      for (OrderedService orderedService : tempServicesArrayToPrint) {
        hotelInformationToPrint.printInformation.getPrintServiceDetails()
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

  public void printGuestByNameServicesByNameDescending(Hotel hotelInformationToPrint,
      String guestName) {
    Guest tempGuest = hotelInformationToPrint.getGuestInRoom(hotelInformationToPrint, guestName);
    OrderedService[] tempServicesArrayToPrint = tempGuest.getOrderedServices().toArray(
        new OrderedService[]{});
    Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
        new ComparatorOrderedServiceByNameAscending());
    if (!tempGuest.getOrderedServices().isEmpty()) {
      OrderedService[] tempServicesToPrintReverseArray = new OrderedService[tempServicesArrayToPrint
          .length];
      for (int i = 0; i < tempServicesArrayToPrint.length; i++) {
        tempServicesToPrintReverseArray[i] = tempServicesArrayToPrint[
            tempServicesToPrintReverseArray.length - 1 - i];
      }
      System.out.println();
      System.out
          .println("The guest " + tempGuest.getGuestName() + " has ordered these services:");
      for (OrderedService orderedService : tempServicesToPrintReverseArray) {
        hotelInformationToPrint.printInformation.getPrintServiceDetails()
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
}
