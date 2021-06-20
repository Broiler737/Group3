package eu.senla.dao;

import eu.senla.model.guest.RegistrationGuests;
import java.util.ArrayList;

public class GuestList {

  final ArrayList<RegistrationGuests> hotelGuests = new ArrayList<>();

  public ArrayList<RegistrationGuests> getHotelGuests() {
    return hotelGuests;
  }
}
