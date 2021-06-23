package eu.senla.utils.comparator.guest;

import eu.senla.model.guest.Guest;
import java.util.Comparator;

public class ComparatorGuestByDateCheckOutDateDescending implements Comparator<Guest> {

  @Override
  public int compare(Guest o1, Guest o2) {
    if (o1.getGuestCheckOutDate().isBefore(o2.getGuestCheckOutDate())) {
      return 1;
    }
    if (o1.getGuestCheckOutDate().isAfter(o2.getGuestCheckOutDate())) {
      return -1;
    }
    return 0;
  }
}
