package eu.senla.hotel;

import eu.senla.api.print.PrintInformation;
import eu.senla.guest.Guest;
import eu.senla.guest.HotelGuest;
import eu.senla.guest.RegistrationGuests;
import eu.senla.room.HotelRooms;
import eu.senla.room.Room;
import eu.senla.service.Service;
import eu.senla.service.Services;
import java.time.LocalDate;

public class Hotel {

  private final HotelRooms hotelRooms = new HotelRooms();
  private final Services services = new Services();
  private final PrintInformation printInformation = new PrintInformation();
  private final HotelGuest hotelGuest = new HotelGuest();

  public Hotel() {
    addingRooms();
    addingServices();
    checkInGuests();
    checkOutGuests();
  }

  public void makingActions() {
    hotelRooms.getHotelRooms().get(6).changeRoomState();
    hotelRooms.getHotelRooms().get(1).changeRoomState();
    hotelRooms.getHotelRooms().get(0).changeRoomPrice(14);
    hotelRooms.getHotelRooms().get(6).changeRoomState();
    getServices().getServices().get(2).changeServicePrice(2.5);
    hotelRooms.getHotelRooms().get(3).addServiceByCounter(4, this);
    hotelRooms.getHotelRooms().get(3).addServiceByName("Parking", this);
  }

  public void addingRooms() {
    hotelRooms.getHotelRooms().add(new Room(1, 2, 2, 10.0));
    hotelRooms.getHotelRooms().add(new Room(2, 3, 2, 15.0));
    hotelRooms.getHotelRooms().add(new Room(3, 4, 2, 20.0));
    hotelRooms.getHotelRooms().add(new Room(4, 2, 1, 8.0));
    hotelRooms.getHotelRooms().add(new Room(5, 1, 1, 5.0));
    hotelRooms.getHotelRooms().add(new Room(6, 2, 3, 15.0));
    hotelRooms.getHotelRooms().add(new Room(7, 3, 3, 20.0));
    hotelRooms.getHotelRooms().add(new Room(8, 4, 3, 25.0));
    hotelRooms.getHotelRooms().get(4).setFree(false);
  }

  public void addingServices() {
    services.addService(new Service("WiFi", 1.0, "InHouse", true));
    services.addService(new Service("Laundry", 3.0, "InHouse", false));
    services.addService(new Service("Parking", 1.5, "Outdoor", true));
    services.addService(new Service("CityTour", 20.0, "Outdoor", false));
    services.addService(new Service("Massage", 10.0, "InHouse", false));
    services.addService(new Service("AirportTransfer", 15.0, "Outdoor", false));
  }

  public void checkInGuests() {
    hotelGuest.getHotelGuests()
        .add(hotelGuest.getHotelGuests().size(), new RegistrationGuests(defineRoom(1,2),
            new Guest[]{new Guest("Margaret", "MP45458946", LocalDate.now(), 15)}));
    hotelGuest.getHotelGuests()
        .add(hotelGuest.getHotelGuests().size(), new RegistrationGuests(defineRoom(2,3),
            new Guest[]{new Guest("Mike", "FT1234567", LocalDate.now(), 10),
                new Guest("Nick", "LR123456", LocalDate.now(), 10)}));
    hotelGuest.getHotelGuests()
        .add(hotelGuest.getHotelGuests().size(), new RegistrationGuests(defineRoom(1,1),
            new Guest[]{new Guest("Bob", "D126546L", LocalDate.now(), 3)}));
    hotelGuest.getHotelGuests()
        .add(hotelGuest.getHotelGuests().size(), new RegistrationGuests(defineRoom(1,3),
            new Guest[]{new Guest("Monica", "PK3650421", LocalDate.now(), 8)}));
    hotelGuest.getHotelGuests()
        .add(hotelGuest.getHotelGuests().size(), new RegistrationGuests(defineRoom(4,2),
            new Guest[]{new Guest("Monica", "QZ6542583", LocalDate.now(), 7),
                new Guest("Dilan", "LR123456", LocalDate.now(), 7),
                new Guest("Lilith", "LY15636858", LocalDate.now(), 7),
                new Guest("Tom", "ZX670439", LocalDate.now(), 7)}));
    System.out.println("Print results of check-in guests");
    System.out.println();
    printInformation.getPrintAllHotelGuestsByRoomNumber().printAllHotelGuestsByRoomNumber(this);
  }

  public void checkOutGuests() {
    hotelGuest.getRegisteredGuests(2).checkOutGuests(hotelRooms.getHotelRooms().get(0)
        .selectRoomByNumber(hotelRooms, hotelGuest.getRegisteredGuests(2).getRoomNumber()));
  }

  private Room defineRoom(int numberOfGuests, int preferableRoomRating) {
    return hotelRooms.getHotelRooms().get(0).selectSuitableRoom(hotelRooms, numberOfGuests, preferableRoomRating);
  }

  public Services getServices() {
    return services;
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