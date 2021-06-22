package eu.senla.api.print.guest;

import eu.senla.model.guest.Guest;
import eu.senla.model.hotel.Hotel;

public class PrintGuestCard {

  public void printGuestCard(Hotel informationToProcessing, Guest guest) {
    printCard(guest);
    if (!guest.getOrderedServices().isEmpty()) {
      System.out.println("Services ordered by guest:");
      System.out.println();
     informationToProcessing.getPrintInformation().getPrintGuestServices().printGuestServices(informationToProcessing,guest);
      System.out
          .println("Guest's debt for services is " + informationToProcessing.getProcessingGuests().countDebtForServiceOfGuest(guest) + "$");
    } else {
      System.out.println("Guest haven't ordered any service");
    }
    System.out.println(
        "Guest debt is " + informationToProcessing.getProcessingGuests().countGuestDebt(informationToProcessing,guest,guest.hashCode())
            + "$ in this moment");
    System.out.println("********** ********** **********");
  }

  public void printArchivedGuestCard(Hotel informationToProcessing, Guest guest) {
    printCard(guest);
    if (!guest.getOrderedServices().isEmpty()) {
      System.out.println("Services ordered by guest:");
      System.out.println();
      informationToProcessing.getPrintInformation().getPrintGuestServices().printGuestServices(informationToProcessing,guest);
      System.out.println(
          "Guest debt is " + (guest.getGuestDebt())
              + "$ in this moment");
      System.out.println("********** ********** **********");
    }
  }

  private void printCard(Guest guest) {
    System.out.println("********** Guest card **********");
    System.out.println("Guest name: " + guest.getGuestName());
    System.out.println("Guest passport #: " + guest.getGuestPassportNumber());
    System.out.println(
        "Guest check-in date " + guest.getGuestCheckInDate() + " and check-out date "
            + guest.getGuestCheckOutDate());
    System.out.println("Guest duration of stay: " + guest.getGuestDurationOfStay() + " days");
  }
}
