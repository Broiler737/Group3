package eu.senla.model.guest;

import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;
import eu.senla.service.SelectRoom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Guest {


  String guestName;
  String guestPassportNumber;
  LocalDate guestCheckInDate;
  LocalDate guestCheckOutDate;
  int guestDurationOfStay;
  ArrayList<OrderedService> orderedServices = new ArrayList<>();
  double guestDebt;

  public Guest() {
  }

  public Guest(String guestName, String guestPassportNumber, LocalDate guestCheckInDate,
      Integer guestDurationOfStay) {
    this.guestName = guestName;
    this.guestPassportNumber = guestPassportNumber;
    this.guestCheckInDate = guestCheckInDate;
    this.guestDurationOfStay = guestDurationOfStay;
    this.guestCheckOutDate = this.guestCheckInDate.plusDays(guestDurationOfStay);
    this.orderedServices = new ArrayList<>();
  }

  public double countDebtForServiceOfGuest() {
    double tempServiceDebt = 0.0;
    for (OrderedService orderedService : this.orderedServices) {
      double tempDebt = 0.0;
      if (orderedService.getOrderedService().isPerDay()) {
        tempDebt = tempDebt
            + orderedService.getDurationOfUseService() * orderedService.getOrderedService()
            .getServicePrice();
      } else {
        tempDebt = tempDebt
            + orderedService.getCountOfOrderingService() * orderedService.getOrderedService()
            .getServicePrice();
      }
      tempServiceDebt = tempServiceDebt + tempDebt;
    }
    return tempServiceDebt;
  }

  public double countGuestDebt(Hotel informationToProcessing, int guestHash) {

    double tempDebt = 0.0;
    double tempServiceDebt = countDebtForServiceOfGuest();
    tempDebt = tempDebt + tempServiceDebt;
    double roomPrice = informationToProcessing.getSelectRoom().findGuestRoom(informationToProcessing, guestHash).getRoomPrice();
    tempDebt = tempDebt + guestDurationOfStay * roomPrice;
    setGuestDebt(tempDebt);
    return tempDebt;
  }

  public void printGuestServices(Hotel informationToProcessing) {
    for (OrderedService orderedService : orderedServices) {
      informationToProcessing.printInformation.getPrintServiceDetails()
          .printServiceSimple(orderedService.getOrderedService());
      if (orderedService.getOrderedService().isPerDay()) {
        System.out.println(
            "The guest use this service " + orderedService.getDurationOfUseService() + " days");
      } else {
        System.out.println(
            "The guest use this service " + (orderedService.getCountOfOrderingService())
                + " times");
      }
    }
  }

  public double getGuestDebt() {
    return guestDebt;
  }

  public double getGuestDebtByHash(Hotel informationToProcessing, int guestHash) {
    return countGuestDebt(informationToProcessing, guestHash);
  }

  public String getGuestName() {
    return guestName;
  }

  public ArrayList<OrderedService> getOrderedServices() {
    return orderedServices;
  }

  public String getGuestPassportNumber() {
    return guestPassportNumber;
  }

  public LocalDate getGuestCheckInDate() {
    return guestCheckInDate;
  }

  public LocalDate getGuestCheckOutDate() {
    return guestCheckOutDate;
  }

  public int getGuestDurationOfStay() {
    return guestDurationOfStay;
  }

  public void setGuestName(String guestName) {
    this.guestName = guestName;
  }

  public void setGuestPassportNumber(String guestPassportNumber) {
    this.guestPassportNumber = guestPassportNumber;
  }

  public void setGuestCheckInDate(LocalDate guestCheckInDate) {
    this.guestCheckInDate = guestCheckInDate;
  }

  public void setGuestCheckOutDate(LocalDate guestCheckOutDate) {
    this.guestCheckOutDate = guestCheckOutDate;
  }

  public void setGuestDurationOfStay(int guestDurationOfStay) {
    this.guestDurationOfStay = guestDurationOfStay;
  }

  public void setOrderedServices(ArrayList<OrderedService> orderedServices) {
    this.orderedServices = orderedServices;
  }

  public final void setGuestDebt(double guestDebt) {
    this.guestDebt = guestDebt;
  }

  @Override
  public int hashCode() {
    return Objects.hash(guestName, guestPassportNumber, guestCheckInDate, guestDurationOfStay);
  }
}
