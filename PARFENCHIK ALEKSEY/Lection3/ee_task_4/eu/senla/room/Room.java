package eu.senla.room;

import eu.senla.guest.Guest;
import eu.senla.hotel.Hotel;
import eu.senla.hotel.HotelRooms;
import eu.senla.service.Service;
import eu.senla.service.Services;
import java.util.TreeMap;

public class Room {

  final int roomNumber;
  double roomPrice;
  int roomMaxCapacity;
  final int roomRating;
  boolean isFree;
  boolean isInService;
  static final int HISTORY_DEPTH = 3;
  final TreeMap<Integer, Service> roomServices = new TreeMap<>();
  Guest[][] roomArchivedGuest = new Guest[HISTORY_DEPTH][roomMaxCapacity];

  public Room(int roomNumber, int roomMaxCapacity, int roomRating, double roomPrice) {
    this.roomNumber = roomNumber;
    this.roomPrice = roomPrice;
    this.roomMaxCapacity = roomMaxCapacity;
    this.roomRating = roomRating;
    this.isFree = true;
    this.isInService = true;
  }

  public Room selectRoomByNumber(HotelRooms hotelRooms, int roomNumber) {
    Room tempRoom = null;
    for (Room rooms : hotelRooms.getHotelRoom()
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
    Room[] tempHotelRoom = new Room[hotelRooms.getHotelRoom().size()];
    for (int i = 0; i < hotelRooms.getHotelRoom().size(); i++) {
      tempHotelRoom[i] = hotelRooms.getHotelRoom().get(i);
    }
    for (Room room : tempHotelRoom) {
      if ((room.getRoomMaxCapacity() >= countOfGuests) && (room.isInService())
          && (room.isFree()) && (room.getRoomRating() >= roomRating)) {
        tempRoom = room;
        break;
      } else {
        if ((room.getRoomMaxCapacity() < countOfGuests)) {
          System.out.println(
              "Room #" + room.roomNumber + " has only " + room.getRoomMaxCapacity()
                  + " places. It's not suitable for " + countOfGuests + " guests");
        }
        if ((room.getRoomRating() < roomRating)) {
          System.out.println(
              "Room #" + room.roomNumber + " has only " + room.getRoomRating()
                  + "-star rating. It's not suitable for guests, who want to live in " + roomRating
                  + "-star rating room");
        }
        if (!room.isFree()) {
          System.out.println(
              "Room #" + room.roomNumber + " is not free. You could't check-in guests inside");
        }
        if (!room.isInService()) {
          System.out.println(
              "Room #" + room.roomNumber
                  + " is out-of-service. You could't check-in guests inside");
        }
      }
    }
    return tempRoom;
  }

  public void addServiceByName(String serviceName, Hotel hotel) {
    Service serviceToAdd;
    Services services = hotel.services;
    serviceToAdd = services.selectServiceByName(serviceName);
    roomServices.putIfAbsent(serviceToAdd.getServiceId(), serviceToAdd);
    System.out.println("Service has successful added to room #" + this.roomNumber);
    System.out.println("Information about service below:");
    hotel.printInformation.getPrintServiceDetails().printServiceDetails(serviceToAdd);
  }

  public void addServiceByCounter(int serviceCounter, Hotel hotel) {
    Service serviceToAdd;
    Services services = hotel.services;
    serviceToAdd = services.selectServiceByCounter(serviceCounter);
    roomServices.putIfAbsent(serviceToAdd.getServiceId(), serviceToAdd);
    System.out.println("Service has successful added to room #" + this.roomNumber);
    System.out.println("Information about service below:");
    hotel.printInformation.getPrintServiceDetails().printServiceDetails(serviceToAdd);
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
