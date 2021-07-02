package eu.senla.utils.comparator.room;

import eu.senla.model.room.Room;
import java.util.Comparator;

public class ComparatorRoomByRatingDescending implements Comparator<Room> {

  @Override
  public int compare(Room o1, Room o2) {
    if (o1.getRating() < o2.getRating()) {
      return 1;
    }
    if (o1.getRating() > o2.getRating()) {
      return -1;
    }
    return 0;
  }
}
