package eu.senla.api.print.service;

import eu.senla.guest.Guest;
import eu.senla.guest.OrderedService;
import eu.senla.hotel.Hotel;
import eu.senla.utils.comparator.service.ComparatorOrderedServiceByPriceAscending;
import eu.senla.utils.comparator.service.ComparatorOrderedServiceByPriceDescending;
import java.util.Arrays;

public class PrintGuestServicesByPrice {

  public void printGuestServicesByPriceAscending(Hotel hotelInformationToPrint,
      Guest guestToPrint) {
    if (!guestToPrint.getOrderedServices().isEmpty()) {
      OrderedService[] tempServicesArrayToPrint = guestToPrint.getOrderedServices().toArray(
          new OrderedService[]{});
      Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
          new ComparatorOrderedServiceByPriceAscending());
      System.out
          .println("The guest " + guestToPrint.getGuestName() + " has ordered these services:");
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

  public void printGuestServicesByPriceDescending(Hotel hotelInformationToPrint,
      Guest guestToPrint) {
    if (!guestToPrint.getOrderedServices().isEmpty()) {
      OrderedService[] tempServicesArrayToPrint = guestToPrint.getOrderedServices().toArray(
          new OrderedService[]{});
      Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
          new ComparatorOrderedServiceByPriceDescending());
      System.out
          .println("The guest " + guestToPrint.getGuestName() + " has ordered these services:");
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


  public void printGuestByNameServicesByPriceAscending(Hotel hotelInformationToPrint,
      String guestName) {
    Guest tempGuest = hotelInformationToPrint.getGuestInRoom(hotelInformationToPrint, guestName);
    OrderedService[] tempServicesArrayToPrint = tempGuest.getOrderedServices().toArray(
        new OrderedService[]{});
    Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
        new ComparatorOrderedServiceByPriceAscending());
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

  public void printGuestByNameServicesByPriceDescending(Hotel hotelInformationToPrint,
      String guestName) {
    Guest tempGuest = hotelInformationToPrint.getGuestInRoom(hotelInformationToPrint, guestName);
    OrderedService[] tempServicesArrayToPrint = tempGuest.getOrderedServices().toArray(
        new OrderedService[]{});
    Arrays.sort(tempServicesArrayToPrint, 0, tempServicesArrayToPrint.length,
        new ComparatorOrderedServiceByPriceDescending());
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
}
