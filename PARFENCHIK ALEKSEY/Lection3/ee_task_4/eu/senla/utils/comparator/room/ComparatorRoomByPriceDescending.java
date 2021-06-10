package eu.senla.utils.comparator.room;

import eu.senla.room.Room;
import java.util.Comparator;

public class ComparatorRoomByPriceDescending implements Comparator<Room> {

  public ComparatorRoomByPriceDescending() {
  }

  @Override
  public int compare(Room o1, Room o2) {
    if (o1.getRoomPrice() < o2.getRoomPrice()) {
      return 1;
    }
    if (o1.getRoomPrice() > o2.getRoomPrice()) {
      return -1;
    }
    return 0;
  }
}

