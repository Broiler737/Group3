package eu.senla.model.room;

import eu.senla.model.guest.Guest;
import eu.senla.model.hotel.Hotel;
import eu.senla.dao.RoomsList;
import eu.senla.model.service.Service;
import eu.senla.service.SelectRoom;
import java.util.TreeMap;

public class Room {

  private final int roomNumber;
  private final SelectRoom selectRoom = new SelectRoom();
  private final AddServiceToRoom addServiceToRoom = new AddServiceToRoom(this);
  private double roomPrice;
  private int roomMaxCapacity;
  private int roomRating;
  private boolean isFree;
  private boolean isInService;
  private static final int HISTORY_DEPTH = 3;
  private final TreeMap<Integer, Service> roomServices = new TreeMap<>();
  private Guest[][] roomArchivedGuest = new Guest[HISTORY_DEPTH][roomMaxCapacity];


  public Room(int roomNumber, int roomMaxCapacity, int roomRating, double roomPrice) {
    this.roomNumber = roomNumber;
    this.roomPrice = roomPrice;
    this.roomMaxCapacity = roomMaxCapacity;
    this.roomRating = roomRating;
    this.isFree = true;
    this.isInService = true;
  }

  public Room selectRoomByNumber(RoomsList roomsList, int roomNumber) {
    return selectRoom.selectRoomByNumber(roomsList, roomNumber);
  }

  public Room selectSuitableRoom(RoomsList roomsList, int countOfGuests, int roomRating) {
    return selectRoom.selectSuitableRoom(roomsList, countOfGuests, roomRating);
  }

  public void addServiceByName(String serviceName, Hotel hotel) {
    addServiceToRoom.addServiceByName(serviceName, hotel);
  }

  public void addServiceByCounter(int serviceCounter, Hotel hotel) {
    addServiceToRoom.addServiceByCounter(serviceCounter, hotel);
  }

  public void changeRoomPrice(double roomPrice) {
    this.roomPrice = roomPrice;
    System.out.println("Now room #" + roomNumber + " costs " + roomPrice + "$ per night");
  }

  public void changeRoomState() {
    this.isInService = !this.isInService;
    if (isInService) {
      System.out.println("Now room #" + this.roomNumber + " is in service");
    } else {
      System.out.println("Now room #" + this.roomNumber + " is out of service");
    }
  }

  public final void changeRoomRating(int newRating) {
    this.roomRating = newRating;
  }

  public final void changeRoomCapacity(int newCapacity) {
    this.roomMaxCapacity = newCapacity;
  }
  public void processingArchivedGuests(Room roomToCheckOut, Guest[] currentRoomGuest) {
    Guest[][] tempArchivedGuest = new Guest[HISTORY_DEPTH
        + 1][roomToCheckOut.getRoomMaxCapacity()];
    for (int i = 0; i < roomArchivedGuest.length; i++) {
      if (roomToCheckOut.roomArchivedGuest[i] != null) {
        tempArchivedGuest[i + 1] = roomToCheckOut.getRoomArchivedGuest()[i];
      }
    }
    tempArchivedGuest[0] = currentRoomGuest;
    System.out.println();
    for (int i = 0; i < roomArchivedGuest.length; i++) {
      roomToCheckOut.getRoomArchivedGuest()[i] = tempArchivedGuest[i];
    }
  }

  public Guest[][] getRoomArchivedGuest() {
    return roomArchivedGuest;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  public TreeMap<Integer, Service> getRoomServices() {
    return roomServices;
  }

  public double getRoomPrice() {
    return roomPrice;
  }

  public int getRoomRating() {
    return roomRating;
  }

  public boolean isFree() {
    return isFree;
  }

  public boolean isInService() {
    return isInService;
  }

  public int getRoomMaxCapacity() {
    return roomMaxCapacity;
  }

  public void setFree(boolean free) {
    isFree = free;
  }
}
