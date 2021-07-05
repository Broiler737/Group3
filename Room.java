package eu.senla.room;

import eu.senla.guest.Guest;
import eu.senla.hotel.Hotel;
import eu.senla.service.Service;
import eu.senla.service.Services;
import java.util.TreeMap;

public class Room {

  private static final int HISTORY_DEPTH = 3;
  private final int roomNumber;
  private final TreeMap<Integer, Service> roomServices = new TreeMap<>();
  private double roomPrice;
  private final int roomRating;
  private int roomMaxCapacity;
  private final Guest[][] roomArchivedGuest = new Guest[HISTORY_DEPTH][roomMaxCapacity];
  private boolean isFree;
  private boolean isInService;

  public Room(int roomNumber, int roomMaxCapacity, int roomRating, double roomPrice) {
    this.roomNumber = roomNumber;
    this.roomPrice = roomPrice;
    this.roomRating = roomRating;
    this.roomMaxCapacity = roomMaxCapacity;
    this.isFree = true;
    this.isInService = true;
  }

  public Room selectRoomByNumber(HotelRooms hotelRooms, int roomNumber) {
    Room tempRoom = null;
    for (Room rooms : hotelRooms.getHotelRooms()
    ) {
      if (rooms.roomNumber == roomNumber) {
        tempRoom = rooms;
        break;
      }
    }
    return tempRoom;
  }


  public Room selectSuitableRoom(HotelRooms hotelRooms, int countOfGuests, int roomRating) {
    Room tempRoom = null;
    Room[] tempHotelRoom = new Room[hotelRooms.getHotelRooms().size()];
    for (int i = 0; i < hotelRooms.getHotelRooms().size(); i++) {
      tempHotelRoom[i] = hotelRooms.getHotelRooms().get(i);
    }
    for (Room room : tempHotelRoom) {
      if ((room.getRoomMaxCapacity() >= countOfGuests) && (room.isInService())
          && (room.isFree()) && (room.getRoomRating() >= roomRating)) {
        tempRoom = room;
        break;
      } else {
        System.out.println("Can't find any suitable room");
      }
    }
    return tempRoom;
  }

  public void addServiceByName(String serviceName, Hotel hotel) {
    Service serviceToAdd;
    Services services = hotel.getServices();
    serviceToAdd = services.selectServiceByName(serviceName);
    roomServices.putIfAbsent(serviceToAdd.getServiceId(), serviceToAdd);
    System.out.println("Service has successful added to room #" + this.roomNumber);
    System.out.println("Information about service below:");
    hotel.getPrintInformation().getPrintServiceDetails().printServiceDetails(serviceToAdd);
  }

  public void addServiceByCounter(int serviceCounter, Hotel hotel) {
    Service serviceToAdd;
    Services services = hotel.getServices();
    serviceToAdd = services.selectServiceByCounter(serviceCounter);
    roomServices.putIfAbsent(serviceToAdd.getServiceId(), serviceToAdd);
    System.out.println("Service has successful added to room #" + this.roomNumber);
    System.out.println("Information about service below:");
    hotel.getPrintInformation().getPrintServiceDetails().printServiceDetails(serviceToAdd);
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

  public void processingArchivedGuests(Room roomToCheckOut, Guest[] currentRoomGuest) {
    Guest[][] tempArchivedGuest = new Guest[getHistoryDepth()
        + 1][roomToCheckOut.getRoomMaxCapacity()];
    for (int i = 0; i < getRoomArchivedGuest().length; i++) {
      if (roomToCheckOut.getRoomArchivedGuest(i) != null) {
        System.arraycopy(roomToCheckOut.getRoomArchivedGuest(i), 0, tempArchivedGuest[i], 1,
            roomToCheckOut.getRoomArchivedGuest(i).length);
      }
    }
    System.arraycopy(currentRoomGuest, 0, tempArchivedGuest[0], 0, currentRoomGuest.length);
    for (int i = 0; i < roomArchivedGuest.length; i++) {
      if (roomMaxCapacity >= 0) {
        System.arraycopy(tempArchivedGuest[i], 0, this.getRoomArchivedGuest(i), 0,
            getRoomArchivedGuest(i).length);
      }
    }
  }

  public Guest[] getRoomArchivedGuest(int counter) {
    return roomArchivedGuest[counter];
  }

  public Guest[][] getRoomArchivedGuest() {
    return roomArchivedGuest;
  }

  public static int getHistoryDepth() {
    return HISTORY_DEPTH;
  }

  public int getRoomNumber() {
    return roomNumber;
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
