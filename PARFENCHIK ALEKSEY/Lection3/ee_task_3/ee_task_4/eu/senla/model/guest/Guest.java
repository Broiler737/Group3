package eu.senla.model.guest;

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
        setGuestName(guestName);
        setGuestPassportNumber(guestPassportNumber);
        setGuestCheckInDate(guestCheckInDate);
        setGuestDurationOfStay(guestDurationOfStay);
        setGuestCheckOutDate(getGuestCheckInDate().plusDays(getGuestDurationOfStay()));
        setOrderedServices(new ArrayList<>());
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
    public String getGuestName() {
        return guestName;
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

    public ArrayList<OrderedService> getOrderedServices() {
        return orderedServices;
    }

    public double getGuestDebt() {
        return guestDebt;
    }



    @Override
    public int hashCode() {
        return Objects.hash(guestName, guestPassportNumber, guestCheckInDate, guestDurationOfStay);
    }
}
