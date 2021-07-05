package eu.senla.guest;

import java.util.ArrayList;

public class HotelGuest {

  private final ArrayList<RegistrationGuests> hotelGuests = new ArrayList<>();

  public RegistrationGuests getRegisteredGuests(int roomNumber) {
    RegistrationGuests tempRoomAndGuests = null;
    for (RegistrationGuests hotelGuest : this.hotelGuests) {
      if (hotelGuest.getRoomNumber() == roomNumber) {
        tempRoomAndGuests = hotelGuest;
        break;
      }
    }
    return tempRoomAndGuests;
  }

  public ArrayList<RegistrationGuests> getHotelGuests() {
    return hotelGuests;
  }
}
