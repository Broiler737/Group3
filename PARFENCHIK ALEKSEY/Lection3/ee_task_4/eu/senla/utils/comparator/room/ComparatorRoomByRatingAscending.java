package eu.senla.utils.comparator.room;

import eu.senla.room.Room;
import java.util.Comparator;

public class ComparatorRoomByRatingAscending implements Comparator<Room> {

  @Override
  public int compare(Room o1, Room o2) {
    if (o1.getRoomRating() < o2.getRoomRating()) {
      return -1;
    }
    if (o1.getRoomRating() > o2.getRoomRating()) {
      return 1;
    }
    return 0;
  }
}
