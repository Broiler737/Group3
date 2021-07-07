package eu.senla.dao;


import eu.senla.model.guest.Guest;
import java.util.ArrayList;
import java.util.List;

public class GuestDao {
  List<Guest> guestsList= new ArrayList<>();

  public List<Guest> getGuestsList() {
    return guestsList;
  }

}
