package eu.senla.model.guest;

public class GuestsAndRooms {

  final Guest guest;
  final int roomNumber;

  public GuestsAndRooms(Guest guest, int roomNumber) {
    this.guest = guest;
    this.roomNumber = roomNumber;
  }

  public Guest getGuest() {
    return guest;
  }

  public int getRoomNumber() {
    return roomNumber;
  }
}
