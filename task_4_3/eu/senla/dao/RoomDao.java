package eu.senla.dao;

import eu.senla.model.room.Room;
import java.util.ArrayList;
import java.util.List;

public class RoomDao {

  final ArrayList<Room> roomsList = new ArrayList<>();

  public ArrayList<Room> getRoomsList() {
    return roomsList;
  }

  public void addRoom(int roomNumber, int roomMaxCapacity, int roomRating,
      double roomPrice) {
    this.getRoomsList().add(new Room(roomNumber, roomMaxCapacity, roomRating, roomPrice));
  }
}

