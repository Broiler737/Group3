package eu.senla.api.print.room;

import eu.senla.hotel.Hotel;
import eu.senla.room.Room;
import eu.senla.utils.comparator.room.ComparatorRoomByRatingAscending;
import eu.senla.utils.comparator.room.ComparatorRoomByRatingDescending;
import java.util.Arrays;

public class PrintHotelRoomsByRating {

  public void printHotelRoomsByRatingAscending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.hotelRooms.getHotelRoom().size()];
    for (int i = 0; i < hotelInformationToPrint.hotelRooms.getHotelRoom().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.hotelRooms.getHotelRoom().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByRatingAscending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      hotelInformationToPrint.printInformation.getPrintRoomDetails()
          .printRoomDetails(hotelInformationToPrint, roomToPrint);
    }
  }

  public void printHotelRoomsByRatingDescending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.hotelRooms.getHotelRoom().size()];
    for (int i = 0; i < hotelInformationToPrint.hotelRooms.getHotelRoom().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.hotelRooms.getHotelRoom().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByRatingDescending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      hotelInformationToPrint.printInformation.getPrintRoomDetails()
          .printRoomDetails(hotelInformationToPrint, roomToPrint);
    }
  }
}
