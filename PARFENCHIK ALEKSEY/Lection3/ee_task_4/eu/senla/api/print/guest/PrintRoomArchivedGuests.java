package eu.senla.api.print.guest;

import eu.senla.hotel.Hotel;
import eu.senla.room.Room;

public class PrintRoomArchivedGuests {

  public void printRoomArchivedGuests(Hotel hotelInformationToPrint, Room room) {
    boolean isAnybodyLivedHere = false;
    for (int i = 0; i < room.getRoomArchivedGuest().length; i++) {
      boolean tempIsAnybodyLivedHere = false;
      for (int j = 0; j < room.getRoomArchivedGuest()[i].length; j++) {
        if (room.getRoomArchivedGuest()[i][j] != null) {
          tempIsAnybodyLivedHere = true;
          break;
        }
      }
      isAnybodyLivedHere = tempIsAnybodyLivedHere;
      if (isAnybodyLivedHere) {
        break;
      }
    }
    if (isAnybodyLivedHere) {
      for (int i = 0; i < room.getRoomArchivedGuest().length; i++) {
        if (room.getRoomArchivedGuest()[i].length == 0) {
          System.out.println("Nobody lived here before previous guest");
          break;
        }
        System.out.println("Guests #" + (i + 1) + " who lived before current guest");
        for (int j = 0; j < room.getRoomArchivedGuest()[i].length; j++) {
          if (room.getRoomArchivedGuest()[i][j] != null) {
            hotelInformationToPrint.printInformation.getPrintGuestCard()
                .printArchivedGuestCard(hotelInformationToPrint, room.getRoomArchivedGuest()[i][j]);
          }
        }
      }
    } else {
      System.out.println("Nobody lived here before");
    }
  }
}
