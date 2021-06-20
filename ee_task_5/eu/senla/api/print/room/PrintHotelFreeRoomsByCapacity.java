package eu.senla.api.print.room;

import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;
import eu.senla.utils.comparator.room.ComparatorRoomByCapacityAscending;
import eu.senla.utils.comparator.room.ComparatorRoomByCapacityDescending;
import java.util.Arrays;

public class PrintHotelFreeRoomsByCapacity {

  public void printHotelFreeRoomsByCapacityAscending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.roomsList.getHotelRoom().size()];
    for (int i = 0; i < hotelInformationToPrint.roomsList.getHotelRoom().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.roomsList.getHotelRoom().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByCapacityAscending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      if (roomToPrint.isFree()) {
        hotelInformationToPrint.printInformation.getPrintRoomDetails()
            .printRoomDetails(hotelInformationToPrint, roomToPrint);
      }
    }
  }

  public void printHotelFreeRoomsByCapacityDescending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.roomsList.getHotelRoom().size()];
    for (int i = 0; i < hotelInformationToPrint.roomsList.getHotelRoom().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.roomsList.getHotelRoom().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByCapacityDescending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      if (roomToPrint.isFree()) {
        hotelInformationToPrint.printInformation.getPrintRoomDetails()
            .printRoomDetails(hotelInformationToPrint, roomToPrint);
      }
    }
  }
}
