package eu.senla.utils.comparator.room;

import eu.senla.model.room.Room;
import java.util.Comparator;

public class ComparatorRoomByPriceAscending implements Comparator<Room> {

  public ComparatorRoomByPriceAscending() {
  }

  @Override
  public int compare(Room o1, Room o2) {
    if (o1.getPrice() < o2.getPrice()) {
      return -1;
    }
    if (o1.getPrice() > o2.getPrice()) {
      return 1;
    }
    return 0;
  }
}
