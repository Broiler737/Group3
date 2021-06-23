package eu.senla.model.guest;

import eu.senla.model.hotel.Hotel;
import eu.senla.model.service.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

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

    public static class OrderedService {

      final Service orderedService;
      final LocalDate dateOfOrderingService;
      final LocalDate dateOfEndingUseService;
      int durationOfUseService;
      int countOfOrderingService;

      public OrderedService(Hotel informationToProcessing, String serviceName,
                            LocalDate dateOfOrderingService, LocalDate dateOfEndingUseService) {
        Service tempService = informationToProcessing.getProcessingServices().selectServiceByName(serviceName);
        this.orderedService = tempService;
        this.dateOfOrderingService = dateOfOrderingService;
        this.dateOfEndingUseService = dateOfEndingUseService;
        if (tempService.isPerDay()) {
          this.durationOfUseService = (int) DAYS.between(dateOfOrderingService, dateOfEndingUseService);
          this.countOfOrderingService = 0;
        } else {
          this.countOfOrderingService = 1;
          this.durationOfUseService = 0;
        }
      }

      public OrderedService(Hotel informationToProcessing, int serviceNumber,
          LocalDate dateOfOrderingService, LocalDate dateOfEndingUseService) {
        this.orderedService = informationToProcessing.getProcessingServices().selectServiceByCounter(serviceNumber);
        this.dateOfOrderingService = dateOfOrderingService;
        this.dateOfEndingUseService = dateOfEndingUseService;
        this.durationOfUseService = (int) DAYS.between(dateOfOrderingService, dateOfEndingUseService);
      }

      public LocalDate getDateOfOrderingService() {
        return dateOfOrderingService;
      }

      public LocalDate getDateOfEndingUseService() {
        return dateOfEndingUseService;
      }

      public int getDurationOfUseService() {
        return durationOfUseService;
      }

      public int getCountOfOrderingService() {
        return countOfOrderingService;
      }

      public void setCountOfOrderingService(int countOfOrderingService) {
        this.countOfOrderingService = countOfOrderingService;
      }

      public void setDurationOfUseService(int durationOfUseService) {
        this.durationOfUseService = durationOfUseService;
      }

      public Service getOrderedService() {
        return orderedService;
      }
    }
}
