package eu.senla.api.print.hotel;

import eu.senla.hotel.Hotel;
import eu.senla.room.Room;
import java.time.LocalDate;

public class PrintListOfFreeInFutureRoomsInHotel {

  public void printListOfFreeInFutureRoomsInHotel(Hotel hotel, LocalDate dateToCheck) {
    Room[] tempRoomArray = hotel.hotelRooms.getFreeInFutureRooms(hotel, dateToCheck);
    System.out.println(
        "At " + dateToCheck + " in hotel, will be free these rooms:");
    for (Room roomToPrint : tempRoomArray
    ) {
      hotel.printInformation.getPrintRoomDetails().printRoomDetails(hotel, roomToPrint);
    }
  }
}
