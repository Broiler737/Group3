package eu.senla.utils.comparator.guest;

import eu.senla.model.guest.Guest;
import java.util.Comparator;

public class ComparatorGuestByNameAscending implements Comparator<Guest> {

  @Override
  public int compare(Guest o1, Guest o2) {
    return o1.getGuestName().compareTo(o2.getGuestName());
  }
}
