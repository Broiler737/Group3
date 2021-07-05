package eu.senla.guest;

import java.time.LocalDate;
import java.util.Objects;

public class Guest {

  private String guestName;
  private String guestPassportNumber;
  private LocalDate guestCheckInDate;
  private LocalDate guestCheckOutDate;
  private int guestDurationOfStay;

  public Guest() {
  }

  public Guest(String guestName, String guestPassportNumber, LocalDate guestCheckInDate,
      Integer guestDurationOfStay) {
    this.guestName = guestName;
    this.guestPassportNumber = guestPassportNumber;
    this.guestCheckInDate = guestCheckInDate;
    this.guestDurationOfStay = guestDurationOfStay;
    this.guestCheckOutDate = this.guestCheckInDate.plusDays(guestDurationOfStay);
  }

  public String getGuestName() {
    return guestName;
  }

  public void setGuestName(String guestName) {
    this.guestName = guestName;
  }

  public String getGuestPassportNumber() {
    return guestPassportNumber;
  }

  public void setGuestPassportNumber(String guestPassportNumber) {
    this.guestPassportNumber = guestPassportNumber;
  }

  public LocalDate getGuestCheckInDate() {
    return guestCheckInDate;
  }

  public void setGuestCheckInDate(LocalDate guestCheckInDate) {
    this.guestCheckInDate = guestCheckInDate;
  }

  public LocalDate getGuestCheckOutDate() {
    return guestCheckOutDate;
  }

  public void setGuestCheckOutDate(LocalDate guestCheckOutDate) {
    this.guestCheckOutDate = guestCheckOutDate;
  }

  public int getGuestDurationOfStay() {
    return guestDurationOfStay;
  }

  public void setGuestDurationOfStay(int guestDurationOfStay) {
    this.guestDurationOfStay = guestDurationOfStay;
  }

  @Override
  public int hashCode() {
    return Objects.hash(guestName, guestPassportNumber, guestCheckInDate, guestDurationOfStay);
  }

}
