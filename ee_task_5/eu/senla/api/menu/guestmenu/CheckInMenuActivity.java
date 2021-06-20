package eu.senla.api.menu.guestmenu;

import eu.senla.utils.userinput.ProcessUserInput;
import eu.senla.model.guest.RegistrationGuests;
import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;

public class CheckInMenuActivity {

  public void checkInMenuActivity(Hotel hotel, ProcessUserInput processUserInput) {
    int tempCountOfGuests;
    int tempGuestRoomRating;
    Room tempRoom = null;
    System.out.println("Please enter quantity of guests");
    tempCountOfGuests = processUserInput.processUserIntegerNumericInput();
    System.out.println("Please enter preferable guest room rating");
    tempGuestRoomRating = processUserInput.processUserIntegerNumericInput();
    try {
      tempRoom = hotel.defineRoom(tempCountOfGuests, tempGuestRoomRating);
    } catch (NullPointerException e) {
      System.out.println("System couldn't find any suitable room");
    }
    if (tempRoom != null) {
      hotel.getGuestList().getHotelGuests().add(hotel.getGuestList().getHotelGuests().size(),
          new RegistrationGuests(processUserInput, tempRoom, tempCountOfGuests));
      hotel.getPrintInformation().getPrintRoomDetails().printRoomDetails(hotel, tempRoom);
    } else {
      System.out.println("System couldn't find any suitable room");
    }
  }
}

