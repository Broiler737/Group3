package eu.senla.model.guest;

import eu.senla.service.ServiceService.OrderedService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Guest {
    private String fullName;
    private String passportNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int durationOfStay;
    private ArrayList<OrderedService> orderedServices = new ArrayList<>();
    private double debt;

    public Guest() {
    }

    public Guest(String fullName, String passportNumber, LocalDate checkInDate,
                 Integer durationOfStay) {
        setFullName(fullName);
        setPassportNumber(passportNumber);
        setCheckInDate(checkInDate);
        setDurationOfStay(durationOfStay);
        setCheckOutDate(getCheckInDate().plusDays(getDurationOfStay()));
        setOrderedServices(new ArrayList<>());
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setDurationOfStay(int durationOfStay) {
        this.durationOfStay = durationOfStay;
    }

    public void setOrderedServices(ArrayList<OrderedService> orderedServices) {
        this.orderedServices = orderedServices;
    }

    public final void setDebt(double debt) {
        this.debt = debt;
    }
    public String getFullName() {
        return fullName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public int getDurationOfStay() {
        return durationOfStay;
    }

    public ArrayList<OrderedService> getOrderedServices() {
        return orderedServices;
    }

    public double getDebt() {
        return debt;
    }



    @Override
    public int hashCode() {
        return Objects.hash(fullName, passportNumber, checkInDate, durationOfStay);
    }

}
