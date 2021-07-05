package eu.senla.api.print;

import eu.senla.guest.Guest;

public class PrintGuestCard {

  public void printGuestCard(Guest guest) {
    System.out.println("********** Guest card **********");
    System.out.println("Guest name: " + guest.getGuestName());
    System.out.println("Guest passport #: " + guest.getGuestPassportNumber());
    System.out.println(
        "Guest check-in date " + guest.getGuestCheckInDate() + " and check-out date "
            + guest.getGuestCheckOutDate());
    System.out.println("Guest duration of stay: " + guest.getGuestDurationOfStay() + " days");
    System.out.println("********** ********** **********");
  }

}
