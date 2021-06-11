package eu.senla.api.print.room;

import eu.senla.hotel.Hotel;
import eu.senla.room.Room;
import eu.senla.service.Service;

public class PrintRoomDetails {

  public void printRoomDetails(Hotel hotelInformationToPrint, Room room) {
    System.out.println();
    System.out.println("########## Room #" + room.getRoomNumber() + " details ##########");
    System.out.println("Room Number #" + room.getRoomNumber());
    System.out.println("The room has " + room.getRoomRating() + "-star rating");
    System.out.println("Maximum guests in room is " + room.getRoomMaxCapacity() + " guests");
    System.out.println("In this room guest could use these services:");
    for (Service roomServicesToPrint : room.getRoomServices().values()
    ) {
      hotelInformationToPrint.printInformation.getPrintServiceDetails()
          .printServiceDetails(roomServicesToPrint);
    }
    System.out.println("Price per night in this room is " + room.getRoomPrice() + "$");
    System.out.println("Is this room in service? - " + room.isInService());
    System.out.println("Is this room free? - " + room.isFree());
    System.out.println("These guests were lived in  in this room before:");
    hotelInformationToPrint.printInformation.getPrintRoomArchivedGuests()
        .printRoomArchivedGuests(hotelInformationToPrint, room);
  }

}
