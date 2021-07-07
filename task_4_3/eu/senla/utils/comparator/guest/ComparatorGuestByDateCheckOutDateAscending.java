package eu.senla.utils.comparator.guest;

import eu.senla.model.guest.Guest;
import java.util.Comparator;

public class ComparatorGuestByDateCheckOutDateAscending implements Comparator<Guest> {

  @Override
  public int compare(Guest o1, Guest o2) {
    if (o1.getCheckOutDate().isBefore(o2.getCheckOutDate())) {
      return -1;
    }
    if (o1.getCheckOutDate().isAfter(o2.getCheckOutDate())) {
      return 1;
    }
    return 0;
  }
}
