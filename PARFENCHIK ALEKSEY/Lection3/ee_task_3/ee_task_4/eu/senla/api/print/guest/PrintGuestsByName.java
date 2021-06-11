package eu.senla.api.print.guest;

import eu.senla.guest.GuestsAndRooms;
import eu.senla.hotel.Hotel;
import eu.senla.utils.comparator.guest.ComparatorGuestByNameAscending;
import java.util.Arrays;

public class PrintGuestsByName {

  public void printGuestsByNameAscending(Hotel hotelInformationToPrint) {
    GuestsAndRooms[] tempGuestsAndRoomsArray;
    tempGuestsAndRoomsArray = hotelInformationToPrint.processingGuestList
        .getGuestsAndRooms(hotelInformationToPrint);
    Arrays.sort(tempGuestsAndRoomsArray, 0, tempGuestsAndRoomsArray.length,
        new ComparatorGuestByNameAscending());
    for (GuestsAndRooms guestsAndRooms : tempGuestsAndRoomsArray) {
      System.out.println(guestsAndRooms.getRoomNumber());
      hotelInformationToPrint.printInformation.getPrintGuestCard()
          .printGuestCard(hotelInformationToPrint, guestsAndRooms.getGuest());
    }
  }

  public void printGuestsByNameDescending(Hotel hotelInformationToPrint) {
    GuestsAndRooms[] tempGuestsAndRoomsArray;
    tempGuestsAndRoomsArray = hotelInformationToPrint.processingGuestList
        .getGuestsAndRooms(hotelInformationToPrint);
    GuestsAndRooms[] tempGuestsAndRoomsReverseArray = new GuestsAndRooms[tempGuestsAndRoomsArray.length];
    Arrays.sort(tempGuestsAndRoomsArray, 0, tempGuestsAndRoomsArray.length,
        new ComparatorGuestByNameAscending());
    for (int i = 0; i < tempGuestsAndRoomsArray.length; i++) {
      tempGuestsAndRoomsReverseArray[i] = tempGuestsAndRoomsArray[tempGuestsAndRoomsArray.length - 1
          - i];
    }
    for (GuestsAndRooms guestsAndRooms : tempGuestsAndRoomsReverseArray) {
      System.out.println(guestsAndRooms.getRoomNumber());
      hotelInformationToPrint.printInformation.getPrintGuestCard()
          .printGuestCard(hotelInformationToPrint, guestsAndRooms.getGuest());
    }
  }
}
