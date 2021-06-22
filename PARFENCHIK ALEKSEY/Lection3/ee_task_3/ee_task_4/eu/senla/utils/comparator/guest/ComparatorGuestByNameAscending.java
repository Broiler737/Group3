package eu.senla.utils.comparator.guest;

import eu.senla.model.guest.GuestsAndRooms;
import java.util.Comparator;

public class ComparatorGuestByNameAscending implements Comparator<GuestsAndRooms> {

  @Override
  public int compare(GuestsAndRooms o1, GuestsAndRooms o2) {
    return o1.getGuest().getGuestName().compareTo(o2.getGuest().getGuestName());
  }
}
