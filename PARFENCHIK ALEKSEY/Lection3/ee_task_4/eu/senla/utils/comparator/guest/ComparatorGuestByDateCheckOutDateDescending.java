package eu.senla.utils.comparator.guest;

import eu.senla.guest.GuestsAndRooms;
import java.util.Comparator;

public class ComparatorGuestByDateCheckOutDateDescending implements Comparator<GuestsAndRooms> {

  @Override
  public int compare(GuestsAndRooms o1, GuestsAndRooms o2) {
    if (o1.getGuest().getGuestCheckOutDate().isBefore(o2.getGuest().getGuestCheckOutDate())) {
      return 1;
    }
    if (o1.getGuest().getGuestCheckOutDate().isAfter(o2.getGuest().getGuestCheckOutDate())) {
      return -1;
    }
    return 0;
  }
}
