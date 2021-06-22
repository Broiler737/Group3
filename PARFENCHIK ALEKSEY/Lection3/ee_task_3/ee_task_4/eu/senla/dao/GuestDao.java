package eu.senla.dao;

import eu.senla.model.guest.RegistrationGuests;
import java.util.ArrayList;

public class GuestDao {

  final ArrayList<RegistrationGuests> guestsList = new ArrayList<>();

  public ArrayList<RegistrationGuests> getGuestsList() {
    return guestsList;
  }
}
