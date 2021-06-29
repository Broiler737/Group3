package eu.senla.dao;

import eu.senla.model.room.Room;
import java.util.ArrayList;

public class RoomsDao {

  final ArrayList<Room> roomsList = new ArrayList<>();

  public ArrayList<Room> getRoomsList() {
    return roomsList;
  }
}

