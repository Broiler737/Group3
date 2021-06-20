package eu.senla.api.menu.guestmenu;

import eu.senla.utils.userinput.ProcessUserInput;
import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;

public class CheckOutMenuActivity {

  public void checkOutMenuActivity(Hotel hotel, ProcessUserInput processUserInput) {
    Room roomToCheckOut = null;
    int roomToCheckOutNumber;
    do {
      System.out.println("Please enter number room for check-out");
      roomToCheckOutNumber = processUserInput.processUserIntegerNumericInput();
    } while (roomToCheckOutNumber == 0);
    roomToCheckOut = hotel.getSelectRoom()
        .selectRoomByNumber(hotel.getRoomsList(), roomToCheckOutNumber);
    try {
      hotel.getRoomForServices(roomToCheckOutNumber).checkOutGuests(roomToCheckOut);
    } catch (NullPointerException e) {
      if (roomToCheckOutNumber > hotel.getRoomsList().getHotelRoom().size()) {
        System.out.println("Room with #" + roomToCheckOutNumber + " is not exist in hotel");
      } else {
        System.out.println("This room was check-out before");
      }
    }
  }
}
