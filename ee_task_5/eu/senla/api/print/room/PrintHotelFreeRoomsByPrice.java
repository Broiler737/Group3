package eu.senla.api.print.room;

import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;
import eu.senla.utils.comparator.room.ComparatorRoomByPriceAscending;
import eu.senla.utils.comparator.room.ComparatorRoomByPriceDescending;
import java.util.Arrays;

public class PrintHotelFreeRoomsByPrice {

  public void printHotelFreeRoomsByPriceAscending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.roomsList.getHotelRoom().size()];
    for (int i = 0; i < hotelInformationToPrint.roomsList.getHotelRoom().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.roomsList.getHotelRoom().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByPriceAscending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      if (roomToPrint.isFree()) {
        hotelInformationToPrint.printInformation.getPrintRoomDetails()
            .printRoomDetails(hotelInformationToPrint, roomToPrint);
      }
    }
  }

  public void printHotelFreeRoomsByPriceDescending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.roomsList.getHotelRoom().size()];
    for (int i = 0; i < hotelInformationToPrint.roomsList.getHotelRoom().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.roomsList.getHotelRoom().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByPriceDescending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      if (roomToPrint.isFree()) {
        hotelInformationToPrint.printInformation.getPrintRoomDetails()
            .printRoomDetails(hotelInformationToPrint, roomToPrint);
      }
    }
  }
}
