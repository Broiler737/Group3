package eu.senla.hotel;

import eu.senla.api.print.PrintInformation;
import eu.senla.dao.ProcessingGuestList;
import eu.senla.guest.AddingServiceToGuest;
import eu.senla.guest.Guest;
import eu.senla.guest.GuestsAndRooms;
import eu.senla.guest.RegistrationGuests;
import eu.senla.room.Room;
import eu.senla.service.Service;
import eu.senla.service.Services;
import java.time.LocalDate;

public class Hotel {

  public final HotelRooms hotelRooms = new HotelRooms();
  public final Services services = new Services();
  public final ProcessingGuestList processingGuestList = new ProcessingGuestList();
  public final PrintInformation printInformation = new PrintInformation();
  public final HotelGuest hotelGuest = new HotelGuest();
  public final AddingServiceToGuest addingServiceToGuest = new AddingServiceToGuest();

  public Hotel() {
    addingRooms();
    addingServices();
    checkInGuests();
    addingServicesToOneGuest();
    addingServicesToWholeRoom();
    checkOutGuests();
  }

  public void makingActions() {
    hotelRooms.getHotelRoom().get(6).changeRoomState();
    hotelRooms.getHotelRoom().get(1).changeRoomState();
    hotelRooms.getHotelRoom().get(0).changeRoomPrice(14);
    hotelRooms.getHotelRoom().get(6).changeRoomState();
    services.getServices().get(2).changeServicePrice(2.5);
    hotelRooms.getHotelRoom().get(3).addServiceByCounter(4, this);
    hotelRooms.getHotelRoom().get(3).addServiceByName("Parking", this);
  }

  public void addingRooms() {
    hotelRooms.getHotelRoom().add(new Room(1, 2, 2, 1.0));
    hotelRooms.getHotelRoom().add(new Room(2, 3, 2, 2.0));
    hotelRooms.getHotelRoom().add(new Room(3, 4, 2, 3.0));
    hotelRooms.getHotelRoom().add(new Room(4, 2, 1, 4.0));
    hotelRooms.getHotelRoom().add(new Room(5, 1, 1, 5.0));
    hotelRooms.getHotelRoom().add(new Room(6, 2, 3, 6.0));
    hotelRooms.getHotelRoom().add(new Room(7, 3, 3, 7.0));
    hotelRooms.getHotelRoom().add(new Room(8, 4, 3, 8.0));
    hotelRooms.getHotelRoom().get(4).setFree(false);
  }

  public void addingServices() {
    services.addService(new Service("WiFi", 1.0, "InHouse", true));
    services.addService(new Service("Laundry", 3.0, "InHouse", false));
    services.addService(new Service("Parking", 1.5, "Outdoor", true));
    services.addService(new Service("CityTour", 20.0, "Outdoor", false));
    services.addService(new Service("Massage", 10.0, "InHouse", false));
    services.addService(new Service("AirportTransfer", 15.0, "Outdoor", false));
    services.addService(new Service("Gym", 2.0, "InHouse", false));
  }

  public void checkInGuests() {
    hotelGuest.getHotelGuests()
        .add(hotelGuest.getHotelGuests().size(), new RegistrationGuests(defineRoom(1, 2),
            new Guest[]{new Guest("Margaret", "MP45458946", LocalDate.now(), 15)}));
    System.out.println("Guest :");
    printInformation.getPrintGuestCard().printGuestCard(this,
        hotelGuest.getHotelGuests().get(hotelGuest.getHotelGuests().size() - 1)
            .getRegisteredInRoomGuests()
            .get(hotelGuest.getHotelGuests().size() - 1));
    System.out.println("has successful check-in");

    hotelGuest.getHotelGuests()
        .add(hotelGuest.getHotelGuests().size(), new RegistrationGuests(defineRoom(2, 3),
            new Guest[]{new Guest("Mike", "FT1234567", LocalDate.now(), 10),
                new Guest("Nick", "LR123456", LocalDate.now(), 10)}));
    hotelGuest.getHotelGuests()
        .add(hotelGuest.getHotelGuests().size(), new RegistrationGuests(defineRoom(1, 1),
            new Guest[]{new Guest("Bob", "D126546L", LocalDate.now(), 3)}));
    hotelGuest.getHotelGuests()
        .add(hotelGuest.getHotelGuests().size(), new RegistrationGuests(defineRoom(1, 3),
            new Guest[]{new Guest("Monica", "PK3650421", LocalDate.now(), 8)}));
    hotelGuest.getHotelGuests()
        .add(hotelGuest.getHotelGuests().size(), new RegistrationGuests(defineRoom(4, 2),
            new Guest[]{new Guest("Monica", "QZ6542583", LocalDate.now(), 7),
                new Guest("Dilan", "LR123456", LocalDate.now(), 7),
                new Guest("Lilith", "LY15636858", LocalDate.now(), 7),
                new Guest("Tom", "ZX670439", LocalDate.now(), 7)}));
    System.out.println("Print results of check-in guests");
    printInformation.getPrintAllHotelGuestsByRoomNumber().printAllHotelGuestsByRoomNumber(this);
  }

  public void checkOutGuests() {
    hotelGuest.getRegisteredGuests(2).checkOutGuests(hotelRooms.getHotelRoom().get(0)
        .selectRoomByNumber(hotelRooms, hotelGuest.getRegisteredGuests(2).getRoomNumber()));
  }

  public void addingServicesToOneGuest() {
    addingServiceToGuest
        .addingServiceByNameToGuest(this, getGuestInRoom(this, "Margaret"), "laundry");
    addingServiceToGuest
        .addingServiceByNameToGuest(this, getGuestInRoom(this, "Dilan"), "AirportTransfer");
    addingServiceToGuest.addingServiceByNameToGuest(this, getGuestInRoom(this, "Margaret"), "Wifi");
    addingServiceToGuest
        .addingServiceByNameToGuest(this, getGuestInRoom(this, "Margaret"), "Laundry");
    addingServiceToGuest.addingServiceByNameToGuest(this, getGuestInRoom(this, "Tom"), "Parking");
    addingServiceToGuest.addingServiceByNameToGuest(this, getGuestInRoom(this, "Bob"), "cityTour");
    addingServiceToGuest.addingServiceByNameToGuest(this, getGuestInRoom(this, "Mike"), "Wifi");
    addingServiceToGuest.addingServiceByNameToGuest(this, getGuestInRoom(this, "Monica"), "gym");
    addingServiceToGuest
        .addingServiceByNameToGuest(this, getGuestInRoom(this, "Margaret"), "Laundry");
    addingServiceToGuest.addingServiceByNameToGuest(this, getGuestInRoom(this, "Tom"), "Parking");
    addingServiceToGuest
        .addingServiceByNameToGuest(this, getGuestInRoom(this, "Monica"), "massage");
    addingServiceToGuest
        .addingServiceByNameToGuest(this, getGuestInRoom(this, "Dilan"), "AirportTransfer");
    addingServiceToGuest
        .addingServiceByNameToGuest(this, getGuestInRoom(this, "Margaret"), "AirportTransfer");
    System.out.println();
    addingServiceToGuest
        .addingServiceByNameToGuest(this, getGuestInRoom(this, "Dilan"), "Gym");
    addingServiceToGuest
        .addingServiceByNameToGuest(this, getGuestInRoom(this, "Dilan"), "CityTour");
  }

  public void addingServicesToWholeRoom() {
    for (int i = 0; i < getRoomForServices(6).getRegisteredInRoomGuests().size(); i++) {
      addingServiceToGuest.addingServiceByNameToGuest(this,
          getRoomForServices(6).getRegisteredInRoomGuests().get(i), "Massage");
    }
  }

  public RegistrationGuests getRoomForServices(int roomNumber) {
    RegistrationGuests tempRegistrationGuests = null;
    for (int i = 0; i < hotelGuest.getHotelGuests().size(); i++) {
      if (hotelGuest.getHotelGuests().get(i).getRoomNumber() == roomNumber) {
        tempRegistrationGuests = hotelGuest.getHotelGuests().get(i);
        break;
      }
    }
    return tempRegistrationGuests;
  }

  public Guest getGuestInRoom(Hotel informationToProcessing, String guestName) {
    Guest tempGuest = null;
    GuestsAndRooms[] tempGuestAndRoomArray = informationToProcessing.processingGuestList
        .getGuestsAndRooms(informationToProcessing);
    for (GuestsAndRooms guestsAndRooms : tempGuestAndRoomArray) {
      if (guestsAndRooms.getGuest().getGuestName().equals(guestName)) {
        tempGuest = guestsAndRooms.getGuest();
        break;
      }
    }
    return tempGuest;
  }

  private Room defineRoom(int numberOfGuests, int preferableRoomRating) {
    return hotelRooms.getHotelRoom().get(0)
        .selectSuitableRoom(hotelRooms, numberOfGuests, preferableRoomRating);
  }

  public PrintInformation getPrintInformation() {
    return printInformation;
  }

  public HotelGuest getHotelGuest() {
    return hotelGuest;
  }

  @Override
  public String toString() {
    printInformation.printInformation(this);
    return "";
  }
}