package eu.senla.api.print.guest;

import eu.senla.guest.GuestsAndRooms;
import eu.senla.hotel.Hotel;
import eu.senla.utils.comparator.guest.ComparatorGuestByDateCheckOutDateAscending;
import eu.senla.utils.comparator.guest.ComparatorGuestByDateCheckOutDateDescending;
import java.util.Arrays;

public class PrintGuestsByCheckOutDate {

  public void printGuestsByCheckOutDateAscending(Hotel hotelInformationToPrint) {
    GuestsAndRooms[] tempGuestsAndRoomsArray;
    tempGuestsAndRoomsArray = hotelInformationToPrint.processingGuestList
        .getGuestsAndRooms(hotelInformationToPrint);
    Arrays.sort(tempGuestsAndRoomsArray, 0, tempGuestsAndRoomsArray.length,
        new ComparatorGuestByDateCheckOutDateAscending());
    for (GuestsAndRooms guestsAndRooms : tempGuestsAndRoomsArray) {
      System.out.println(guestsAndRooms.getRoomNumber());
      hotelInformationToPrint.printInformation.getPrintGuestCard()
          .printGuestCard(hotelInformationToPrint, guestsAndRooms.getGuest());
    }
  }

  public void printGuestsByCheckOutDateDescending(Hotel hotelInformationToPrint) {
    GuestsAndRooms[] tempGuestsAndRoomsArray;
    tempGuestsAndRoomsArray = hotelInformationToPrint.processingGuestList
        .getGuestsAndRooms(hotelInformationToPrint);
    Arrays.sort(tempGuestsAndRoomsArray, 0, tempGuestsAndRoomsArray.length,
        new ComparatorGuestByDateCheckOutDateDescending());
    for (GuestsAndRooms guestsAndRooms : tempGuestsAndRoomsArray) {
      System.out.println(guestsAndRooms.getRoomNumber());
      hotelInformationToPrint.printInformation.getPrintGuestCard()
          .printGuestCard(hotelInformationToPrint, guestsAndRooms.getGuest());
    }
  }
}
