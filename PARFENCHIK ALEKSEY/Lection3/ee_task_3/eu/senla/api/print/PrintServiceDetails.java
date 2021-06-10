package eu.senla.api.print;

import eu.senla.service.Service;

public class PrintServiceDetails {

  public void printServiceDetails(Service service) {
    System.out.println("    Service ID " + service.getServiceId());
    System.out.println("    Service name: " + service.getServiceName());
    System.out.println("    Service type: " + service.getServiceType());
    if (service.isPerDay()) {
      System.out.println("    Service price is " + service.getServicePrice() + "S per day");
    } else {
      System.out.println("    Service price is " + service.getServicePrice() + "S one time");
    }
  }
}
