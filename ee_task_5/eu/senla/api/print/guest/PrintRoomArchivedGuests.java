package eu.senla.api.print.guest;

import eu.senla.model.guest.Guest;
import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;

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

  public void printRoomArchivedGuestsV1(Hotel hotelInformationToPrint, Room room) {
   /* boolean isAnybodyLivedHere = false;
    for (int i = 0; i < room.getRoomArchivedGuestV1().size(); i++) {
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
    if (!room.getRoomArchivedGuestV1().isEmpty()) {

      for (Guest[] guests : room.getRoomArchivedGuestV1()) {
        hotelInformationToPrint.printInformation.getPrintGuestCard()
            .printArchivedGuestCard(hotelInformationToPrint, guests[0]);
        //room.getRoomArchivedGuestV1().listIterator().next();
      }*/
     /* for (int i = 0; i < room.getRoomArchivedGuest().length; i++) {
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
    }*/
  }
}
