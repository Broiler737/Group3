package eu.senla.service;

import eu.senla.model.guest.Guest;
import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;
import eu.senla.model.service.Service;
import java.time.LocalDate;

public class HotelService {

  private final Hotel hotel;

  public HotelService(Hotel hotel) {
    this.hotel=hotel;
    addingRooms();
    addingServices();
    checkInGuests();
   addingServicesToOneGuest();
   addingServicesToWholeRoom(1,hotel.getServiceService().selectAvailableServiceByName(hotel, "cityTour"));
    checkOutGuests();
  }

  public void addingRooms() {
    hotel.getRoomService().addRoom(hotel, 1, 2, 2, 1);
    hotel.getRoomService().addRoom(hotel, 2, 3, 2, 2);
    hotel.getRoomService().addRoom(hotel, 3, 4, 2, 3);
    hotel.getRoomService().addRoom(hotel, 4, 2, 1, 4);
    hotel.getRoomService().addRoom(hotel, 5, 1, 1, 5);
    hotel.getRoomService().addRoom(hotel, 6, 2, 4, 6);
    hotel.getRoomService().addRoom(hotel, 7, 3, 3, 7);
    hotel.getRoomService().addRoom(hotel, 8, 4, 3, 8);
    hotel.getRoomsDao().getRoomsList().get(4).setFree(false);
  }

  public void addingServices() {
    hotel.getServiceService().addService(hotel, "WiFi", 1.0, "InHouse", true);
    hotel.getServiceService().addService(hotel, "Laundry", 3.0, "InHouse", false);
    hotel.getServiceService().addService(hotel, "Parking", 1.5, "Outdoor", true);
    hotel.getServiceService().addService(hotel, "CityTour", 20.0, "Outdoor", false);
    hotel.getServiceService().addService(hotel, "Massage", 10.0, "InHouse", false);
    hotel.getServiceService().addService(hotel, "AirportTransfer", 15.0, "Outdoor", false);
    hotel.getServiceService().addService(hotel, "Gym", 2.0, "InHouse", false);
  }

  public void checkInGuests() {
    hotel.getGuestService()
        .checkInGuest((hotel.getRoomService().selectSuitableRoom(hotel.getRoomsDao(), 2, 2)),
            new Guest[]{new Guest("Alice", "MP45458946", LocalDate.now(), 15),
                new Guest("Mark", "FT1234567", LocalDate.now(), 15)});
    hotel.getGuestService()
        .checkInGuest((hotel.getRoomService().selectSuitableRoom(hotel.getRoomsDao(), 2, 3)),
            new Guest[]{
                new Guest("Margaret", "MF4558946", LocalDate.now(), 10),
                new Guest("Jane", "XT1248567", LocalDate.now(), 10)});
    hotel.getGuestService()
        .checkInGuest((hotel.getRoomService().selectSuitableRoom(hotel.getRoomsDao(), 2, 2)),
            new Guest[]{
                new Guest("Mike", "FT1234567", LocalDate.now(), 10),
                new Guest("Nick", "LR123456", LocalDate.now(), 10)});
    hotel.getGuestService()
        .checkInGuest((hotel.getRoomService().selectSuitableRoom(hotel.getRoomsDao(), 2, 2)),
            new Guest[]{
                new Guest("Bob", "D126546L", LocalDate.now(), 3)});
    hotel.getGuestService()
        .checkInGuest((hotel.getRoomService().selectSuitableRoom(hotel.getRoomsDao(), 2, 2)),
            new Guest[]{
                new Guest("Monica", "D126546L", LocalDate.now(), 3)});
    hotel.getGuestService()
        .checkInGuest((hotel.getRoomService().selectSuitableRoom(hotel.getRoomsDao(), 2, 2)),
            new Guest[]{
                new Guest("Lilith", "LY15636858", LocalDate.now(), 7),
                new Guest("Dilan", "LR123456", LocalDate.now(), 7),
                new Guest("Tom", "ZX670439", LocalDate.now(), 7),
                new Guest("Kate", "PK3650421", LocalDate.now(), 7)});
    System.out.println("Print results of check-in guests");
    hotel.getPrintInformation().getPrintGuests().printAllHotelGuestsByRoomNumber(hotel);
  }

  public void checkOutGuests() {
    hotel.getGuestService()
        .checkOutGuests(hotel, hotel.getRoomService().selectRoomByNumber(hotel.getRoomsDao(), 1));
  }

  public void addingServicesToOneGuest() {
    hotel.getGuestService()
        .addingServiceByNameToGuest(hotel,
            hotel.getGuestService().selectGuestByName(hotel, "Margaret"),
            "laundry");
    hotel.getGuestService()
        .addingServiceByNameToGuest(hotel,
            hotel.getGuestService().selectGuestByName(hotel, "Dilan"),
            "AirportTransfer");
    hotel.getGuestService().addingServiceByNameToGuest(hotel,
        hotel.getGuestService().selectGuestByName(hotel, "Margaret"), "Wifi");
    hotel.getGuestService()
        .addingServiceByNameToGuest(hotel,
            hotel.getGuestService().selectGuestByName(hotel, "Margaret"),
            "Laundry");
    hotel.getGuestService().addingServiceByNameToGuest(hotel,
        hotel.getGuestService().selectGuestByName(hotel, "Tom"), "Parking");
    hotel.getGuestService().addingServiceByNameToGuest(hotel,
        hotel.getGuestService().selectGuestByName(hotel, "Bob"), "cityTour");
    hotel.getGuestService().addingServiceByNameToGuest(hotel,
        hotel.getGuestService().selectGuestByName(hotel, "Mike"), "Wifi");
    hotel.getGuestService().addingServiceByNameToGuest(hotel,
        hotel.getGuestService().selectGuestByName(hotel, "Monica"), "gym");
    hotel.getGuestService()
        .addingServiceByNameToGuest(hotel,
            hotel.getGuestService().selectGuestByName(hotel, "Margaret"),
            "Laundry");
    hotel.getGuestService().addingServiceByNameToGuest(hotel,
        hotel.getGuestService().selectGuestByName(hotel, "Tom"), "Parking");
    hotel.getGuestService()
        .addingServiceByNameToGuest(hotel,
            hotel.getGuestService().selectGuestByName(hotel, "Monica"),
            "massage");
    hotel.getGuestService()
        .addingServiceByNameToGuest(hotel,
            hotel.getGuestService().selectGuestByName(hotel, "Dilan"),
            "AirportTransfer");
    hotel.getGuestService()
        .addingServiceByNameToGuest(hotel,
            hotel.getGuestService().selectGuestByName(hotel, "Margaret"),
            "AirportTransfer");
    System.out.println();
    hotel.getGuestService()
        .addingServiceByNameToGuest(hotel,
            hotel.getGuestService().selectGuestByName(hotel, "Dilan"),
            "Gym");
    hotel.getGuestService()
        .addingServiceByNumberToGuest(hotel,
            hotel.getGuestService().selectGuestByName(hotel, "Tom"),
            3);
    hotel.getGuestService().addingServiceByNameToGuest(hotel,
        hotel.getGuestService().selectGuestByName(hotel, "Dilan"), "Parking");
  }

  public void addingServicesToWholeRoom(int roomNumber, Service serviceToAdd) {
    Room room = hotel.getRoomService().selectRoomByNumber(hotel.getRoomsDao(), roomNumber);
    for (int i = 0; i < room.getCurrentGuest().size(); i++) {
      hotel.getGuestService()
          .addingServiceByNameToGuest(hotel, hotel.getGuestService()
                  .selectGuestByName(hotel, room.getCurrentGuest().get(i).getName()),
              serviceToAdd.getName());
    }
  }
}