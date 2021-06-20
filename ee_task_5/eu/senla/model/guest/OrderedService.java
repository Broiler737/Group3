package eu.senla.model.guest;

import static java.time.temporal.ChronoUnit.DAYS;

import eu.senla.model.hotel.Hotel;
import eu.senla.model.service.Service;
import java.time.LocalDate;

public class OrderedService {

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
