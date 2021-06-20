package eu.senla.model.hotel;

import eu.senla.api.print.PrintInformation;
import eu.senla.dao.GuestList;
import eu.senla.dao.RoomsList;
import eu.senla.dao.ProcessingGuestList;
import eu.senla.dao.Services;
import eu.senla.model.guest.AddingServiceToGuest;

import eu.senla.model.guest.Guest;
import eu.senla.model.guest.RegistrationGuests;
import eu.senla.model.room.Room;
import eu.senla.model.service.Service;
import eu.senla.service.ProcessingGuests;
import eu.senla.service.ProcessingRooms;
import eu.senla.service.ProcessingServices;
import eu.senla.service.SelectGuest;
import eu.senla.service.SelectRoom;
import java.time.LocalDate;

public class Hotel {

  public final RoomsList roomsList = new RoomsList();
  public final Services services = new Services();
  public final ProcessingGuestList processingGuestList = new ProcessingGuestList();
  public final PrintInformation printInformation = new PrintInformation();
  public final GuestList guestList = new GuestList();
  public final AddingServiceToGuest addingServiceToGuest = new AddingServiceToGuest();
  public final SelectRoom selectRoom = new SelectRoom();
  private final SelectGuest selectGuest = new SelectGuest();
  private final ProcessingServices processingServices = new ProcessingServices(this.getServices());
  private final ProcessingRooms processingRooms = new ProcessingRooms(this.getRoomsList());
  private final ProcessingGuests processingGuests = new ProcessingGuests(this.getGuestList());

  public Hotel() {
    addingRooms();
    addingServices();
    checkInGuests();
    addingServicesToOneGuest();
    addingServicesToWholeRoom();
    checkOutGuests();

  }

  public void addingRooms() {
    roomsList.getHotelRoom().add(new Room(1, 2, 2, 1.0));
    roomsList.getHotelRoom().add(new Room(2, 3, 2, 2.0));
    roomsList.getHotelRoom().add(new Room(3, 4, 2, 3.0));
    roomsList.getHotelRoom().add(new Room(4, 2, 1, 4.0));
    roomsList.getHotelRoom().add(new Room(5, 1, 1, 5.0));
    roomsList.getHotelRoom().add(new Room(6, 2, 3, 6.0));
    roomsList.getHotelRoom().add(new Room(7, 3, 3, 7.0));
    roomsList.getHotelRoom().add(new Room(8, 4, 3, 8.0));
    roomsList.getHotelRoom().get(4).setFree(false);
  }

  public void addingServices() {
    processingServices.addService(new Service("WiFi", 1.0, "InHouse", true));
    processingServices.addService(new Service("Laundry", 3.0, "InHouse", false));
    processingServices.addService(new Service("Parking", 1.5, "Outdoor", true));
    processingServices.addService(new Service("CityTour", 20.0, "Outdoor", false));
    processingServices.addService(new Service("Massage", 10.0, "InHouse", false));
    processingServices.addService(new Service("AirportTransfer", 15.0, "Outdoor", false));
    processingServices.addService(new Service("Gym", 2.0, "InHouse", false));
  }

  public void checkInGuests() {
    guestList.getHotelGuests()
        .add(guestList.getHotelGuests().size(), new RegistrationGuests(defineRoom(1, 2),
            new Guest[]{new Guest("Margaret", "MP45458946", LocalDate.now(), 15)}));
    System.out.println("Guest :");
    printInformation.getPrintGuestCard().printGuestCard(this,
        guestList.getHotelGuests().get(guestList.getHotelGuests().size() - 1)
            .getRegisteredInRoomGuests()
            .get(guestList.getHotelGuests().size() - 1));
    System.out.println("has successful check-in");

    guestList.getHotelGuests()
        .add(guestList.getHotelGuests().size(), new RegistrationGuests(defineRoom(2, 3),
            new Guest[]{new Guest("Mike", "FT1234567", LocalDate.now(), 10),
                new Guest("Nick", "LR123456", LocalDate.now(), 10)}));
    guestList.getHotelGuests()
        .add(guestList.getHotelGuests().size(), new RegistrationGuests(defineRoom(1, 1),
            new Guest[]{new Guest("Bob", "D126546L", LocalDate.now(), 3)}));
    guestList.getHotelGuests()
        .add(guestList.getHotelGuests().size(), new RegistrationGuests(defineRoom(1, 3),
            new Guest[]{new Guest("Monica", "PK3650421", LocalDate.now(), 8)}));
    guestList.getHotelGuests()
        .add(guestList.getHotelGuests().size(), new RegistrationGuests(defineRoom(4, 2),
            new Guest[]{new Guest("Monica", "QZ6542583", LocalDate.now(), 7),
                new Guest("Dilan", "LR123456", LocalDate.now(), 7),
                new Guest("Lilith", "LY15636858", LocalDate.now(), 7),
                new Guest("Tom", "ZX670439", LocalDate.now(), 7)}));
    System.out.println("Print results of check-in guests");
    printInformation.getPrintAllHotelGuestsByRoomNumber().printAllHotelGuestsByRoomNumber(this);
  }

  public void checkOutGuests() {
    getProcessingGuests().getRegisteredGuests(2).checkOutGuests(roomsList.getHotelRoom().get(0)
        .selectRoomByNumber(roomsList, getProcessingGuests().getRegisteredGuests(2).getRoomNumber()));
  }

  public void addingServicesToOneGuest() {
    addingServiceToGuest
        .addingServiceByNameToGuest(this, selectGuest.selectGuestByName(this, "Margaret"),
            "laundry");
    addingServiceToGuest
        .addingServiceByNameToGuest(this, selectGuest.selectGuestByName(this, "Dilan"),
            "AirportTransfer");
    addingServiceToGuest.addingServiceByNameToGuest(this,
        selectGuest.selectGuestByName(this, "Margaret"), "Wifi");
    addingServiceToGuest
        .addingServiceByNameToGuest(this, selectGuest.selectGuestByName(this, "Margaret"),
            "Laundry");
    addingServiceToGuest.addingServiceByNameToGuest(this,
        selectGuest.selectGuestByName(this, "Tom"), "Parking");
    addingServiceToGuest.addingServiceByNameToGuest(this,
        selectGuest.selectGuestByName(this, "Bob"), "cityTour");
    addingServiceToGuest.addingServiceByNameToGuest(this,
        selectGuest.selectGuestByName(this, "Mike"), "Wifi");
    addingServiceToGuest.addingServiceByNameToGuest(this,
        selectGuest.selectGuestByName(this, "Monica"), "gym");
    addingServiceToGuest
        .addingServiceByNameToGuest(this, selectGuest.selectGuestByName(this, "Margaret"),
            "Laundry");
    addingServiceToGuest.addingServiceByNameToGuest(this,
        selectGuest.selectGuestByName(this, "Tom"), "Parking");
    addingServiceToGuest
        .addingServiceByNameToGuest(this, selectGuest.selectGuestByName(this, "Monica"), "massage");
    addingServiceToGuest
        .addingServiceByNameToGuest(this, selectGuest.selectGuestByName(this, "Dilan"),
            "AirportTransfer");
    addingServiceToGuest
        .addingServiceByNameToGuest(this, selectGuest.selectGuestByName(this, "Margaret"),
            "AirportTransfer");
    System.out.println();
    addingServiceToGuest
        .addingServiceByNameToGuest(this, selectGuest.selectGuestByName(this, "Dilan"), "Gym");
    addingServiceToGuest
        .addingServiceByNameToGuest(this, selectGuest.selectGuestByName(this, "Dilan"), "CityTour");
  }

  public void addingServicesToWholeRoom() {
    for (int i = 0; i < getRoomForServices(6).getRegisteredInRoomGuests().size(); i++) {
      addingServiceToGuest.addingServiceByNameToGuest(this,
          getRoomForServices(6).getRegisteredInRoomGuests().get(i), "Massage");
    }
  }

  public RegistrationGuests getRoomForServices(int roomNumber) {
    RegistrationGuests tempRegistrationGuests = null;
    for (int i = 0; i < guestList.getHotelGuests().size(); i++) {
      if (guestList.getHotelGuests().get(i).getRoomNumber() == roomNumber) {
        tempRegistrationGuests = guestList.getHotelGuests().get(i);
        break;
      }
    }
    return tempRegistrationGuests;
  }

  public Guest selectGuestByName(Hotel informationToProcessing, String guestName) {
    return selectGuest.selectGuestByName(informationToProcessing, guestName);
  }

  public Room defineRoom(int numberOfGuests, int preferableRoomRating) {
    return this.getRoomsList().getHotelRoom().get(0)
        .selectSuitableRoom(this.getRoomsList(), numberOfGuests, preferableRoomRating);
  }

  public PrintInformation getPrintInformation() {
    return printInformation;
  }

  public RoomsList getRoomsList() {
    return roomsList;
  }

  public SelectRoom getSelectRoom() {
    return selectRoom;
  }

  public SelectGuest getSelectGuest() {
    return selectGuest;
  }

  public ProcessingGuests getProcessingGuests() {
    return processingGuests;
  }

  public Services getServices() {
    return services;
  }

  public ProcessingGuestList getProcessingGuestList() {
    return processingGuestList;
  }

  public ProcessingServices getProcessingServices() {
    return processingServices;
  }

  public ProcessingRooms getProcessingRooms() {
    return processingRooms;
  }

  public GuestList getGuestList() {
    return guestList;
  }

  @Override
  public String toString() {
    printInformation.printInformation(this);
    return "";
  }
}