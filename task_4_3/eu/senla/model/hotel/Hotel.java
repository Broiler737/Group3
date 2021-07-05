package eu.senla.model.hotel;

import eu.senla.api.print.PrintInformation;
import eu.senla.dao.GuestDao;
import eu.senla.dao.RoomDao;
import eu.senla.dao.ServiceDao;
import eu.senla.model.guest.Guest;
import eu.senla.model.room.Room;
import eu.senla.model.service.Service;
import eu.senla.service.GuestService;
import eu.senla.service.RoomService;
import eu.senla.service.ServiceService;
import java.time.LocalDate;

public class Hotel {

  public final RoomDao roomDao = new RoomDao();
  public final ServiceDao serviceDao = new ServiceDao();
  public final GuestDao guestDao = new GuestDao();
  private final ServiceService serviceService = new ServiceService();
  private final RoomService roomService = new RoomService();
  private final GuestService guestService = new GuestService();
  public final PrintInformation printInformation = new PrintInformation();


  public Hotel() {
    addingRooms();
    addingServices();
    checkInGuests();
    addingServicesToOneGuest();
    addingServicesToWholeRoom(1, getServiceService()
        .selectAvailableServiceByName(this.getServiceDao().getServicesList(), "cityTour"));
    checkOutGuests();
  }


  public void addingRooms() {
    getRoomDao().addRoom(1, 2, 2, 1);
    getRoomDao().addRoom(2, 3, 2, 2);
    getRoomDao().addRoom( 3, 4, 2, 3);
    getRoomDao().addRoom( 4, 2, 1, 4);
    getRoomDao().addRoom( 5, 1, 1, 5);
    getRoomDao().addRoom( 6, 2, 4, 6);
    getRoomDao().addRoom( 7, 3, 3, 7);
    getRoomDao().addRoom( 8, 4, 3, 8);
    getRoomDao().getRoomsList().get(4).setFree(false);
  }

  public void addingServices() {
    getServiceDao()
        .addService(this.getServiceService(), "WiFi", 1.0, "InHouse", true);
    getServiceDao()
        .addService(this.getServiceService(), "Laundry", 3.0, "InHouse", false);
    getServiceDao()
        .addService(this.getServiceService(), "Parking", 1.5, "Outdoor", true);
    getServiceDao()
        .addService(this.getServiceService(), "CityTour", 20.0, "Outdoor", false);
    getServiceDao()
        .addService(this.getServiceService(), "Massage", 10.0, "InHouse", false);
    getServiceDao()
        .addService(this.getServiceService(), "AirportTransfer", 15.0, "Outdoor",
            false);
    getServiceDao()
        .addService(this.getServiceService(), "Gym", 2.0, "InHouse", false);
  }

  public void checkInGuests() {
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomDao().getRoomsList(), 2, 2)),
            new Guest[]{new Guest("Alice", "MP45458946", LocalDate.now(), 15),
                new Guest("Mark", "FT1234567", LocalDate.now(), 15)});
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomDao().getRoomsList(), 2, 3)),
            new Guest[]{
                new Guest("Margaret", "MF4558946", LocalDate.now(), 10),
                new Guest("Jane", "XT1248567", LocalDate.now(), 10)});
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomDao().getRoomsList(), 2, 2)),
            new Guest[]{
                new Guest("Mike", "FT1234567", LocalDate.now(), 10),
                new Guest("Nick", "LR123456", LocalDate.now(), 10)});
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomDao().getRoomsList(), 2, 2)),
            new Guest[]{
                new Guest("Bob", "D126546L", LocalDate.now(), 3)});
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomDao().getRoomsList(), 2, 2)),
            new Guest[]{
                new Guest("Monica", "D126546L", LocalDate.now(), 3)});
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomDao().getRoomsList(), 2, 2)),
            new Guest[]{
                new Guest("Lilith", "LY15636858", LocalDate.now(), 7),
                new Guest("Dilan", "LR123456", LocalDate.now(), 7),
                new Guest("Tom", "ZX670439", LocalDate.now(), 7),
                new Guest("Kate", "PK3650421", LocalDate.now(), 7)});
    System.out.println("Print results of check-in guests");
    getPrintInformation().getPrintGuests()
        .printAllHotelGuestsByRoomNumber(this.getPrintInformation(),
            this.getRoomDao().getRoomsList(), this.getRoomService(), this.getGuestService());
  }

  public void checkOutGuests() {
    getGuestService()
        .checkOutGuests(this.getRoomService(),
            getRoomService().selectRoomByNumber(getRoomDao().getRoomsList(), 1));
  }

  public void addingServicesToOneGuest() {
    getGuestService()
        .addingServiceByNameToGuest(this.getServiceDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomDao().getRoomsList(), "Margaret"),
            "laundry");
    getGuestService()
        .addingServiceByNameToGuest(this.getServiceDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomDao().getRoomsList(), "Dilan"),
            "AirportTransfer");
    getGuestService().addingServiceByNameToGuest(this.getServiceDao().getServicesList(),
        this.getServiceService(),
        getGuestService().selectGuestByName(this.getRoomDao().getRoomsList(), "Margaret"), "Wifi");
    getGuestService()
        .addingServiceByNameToGuest(this.getServiceDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomDao().getRoomsList(), "Margaret"),
            "Laundry");
    getGuestService().addingServiceByNameToGuest(this.getServiceDao().getServicesList(),
        this.getServiceService(),
        getGuestService().selectGuestByName(this.getRoomDao().getRoomsList(), "Tom"), "Parking");
    getGuestService().addingServiceByNameToGuest(this.getServiceDao().getServicesList(),
        this.getServiceService(),
        getGuestService().selectGuestByName(this.getRoomDao().getRoomsList(), "Bob"), "cityTour");
    getGuestService().addingServiceByNameToGuest(this.getServiceDao().getServicesList(),
        this.getServiceService(),
        getGuestService().selectGuestByName(this.getRoomDao().getRoomsList(), "Mike"), "Wifi");
    getGuestService().addingServiceByNameToGuest(this.getServiceDao().getServicesList(),
        this.getServiceService(),
        getGuestService().selectGuestByName(this.getRoomDao().getRoomsList(), "Monica"), "gym");
    getGuestService()
        .addingServiceByNameToGuest(this.getServiceDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomDao().getRoomsList(), "Margaret"),
            "Laundry");
    getGuestService().addingServiceByNameToGuest(this.getServiceDao().getServicesList(),
        this.getServiceService(),
        getGuestService().selectGuestByName(this.getRoomDao().getRoomsList(), "Tom"), "Parking");
    getGuestService()
        .addingServiceByNameToGuest(this.getServiceDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomDao().getRoomsList(), "Monica"),
            "massage");
    getGuestService()
        .addingServiceByNameToGuest(this.getServiceDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomDao().getRoomsList(), "Dilan"),
            "AirportTransfer");
    getGuestService()
        .addingServiceByNameToGuest(this.getServiceDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomDao().getRoomsList(), "Margaret"),
            "AirportTransfer");
    System.out.println();
    getGuestService()
        .addingServiceByNameToGuest(this.getServiceDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomDao().getRoomsList(), "Dilan"),
            "Gym");
    getGuestService()
        .addingServiceByNumberToGuest(this.getServiceDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomDao().getRoomsList(), "Tom"),
            3);
    getGuestService().addingServiceByNameToGuest(this.getServiceDao().getServicesList(),
        this.getServiceService(),
        getGuestService().selectGuestByName(this.getRoomDao().getRoomsList(), "Dilan"), "Parking");
  }

  public void addingServicesToWholeRoom(int roomNumber, Service serviceToAdd) {
    Room room = getRoomService().selectRoomByNumber(getRoomDao().getRoomsList(), roomNumber);
    for (int i = 0; i < room.getCurrentGuest().size(); i++) {
      getGuestService()
          .addingServiceByNameToGuest(this.getServiceDao().getServicesList(),
              this.getServiceService(), getGuestService()
                  .selectGuestByName(this.getRoomDao().getRoomsList(),
                      room.getCurrentGuest().get(i).getFullName()),
              serviceToAdd.getName());
    }
  }

  public PrintInformation getPrintInformation() {
    return printInformation;
  }

  public RoomDao getRoomDao() {
    return roomDao;
  }

  public GuestService getGuestService() {
    return guestService;
  }

  public ServiceDao getServiceDao() {
    return serviceDao;
  }

  public ServiceService getServiceService() {
    return serviceService;
  }

  public RoomService getRoomService() {
    return roomService;
  }

  public GuestDao getGuestDao() {
    return guestDao;
  }

  @Override
  public String toString() {
    printInformation.printInformation(this.getRoomService(), this.getRoomDao().getRoomsList(),
        this.getGuestService(), this.getGuestDao().getGuestsList(), this.getServiceService(),
        this.getServiceDao().getServicesList());
    return "";
  }
}