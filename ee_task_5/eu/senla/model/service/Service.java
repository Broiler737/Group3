package eu.senla.model.service;

import java.util.Objects;

public class Service {

  private int serviceId;
  private final String serviceName;
  private final String serviceType;
  private double servicePrice;
  private boolean isAvailable;
  private final boolean perDay;

  public Service(String serviceName, Double servicePrice, String serviceType, Boolean perDay) {
    this.serviceName = serviceName;
    this.servicePrice = servicePrice;
    this.serviceType = serviceType;
    this.perDay = perDay;
    this.isAvailable = true;
  }

  public void changeServicePrice(Double servicePrice) {
    this.servicePrice = servicePrice;
    System.out.println("Now " + serviceName + " price is " + servicePrice + "$");
  }

  public void changeServiceAvailability() {
    isAvailable = !isAvailable;
    if (isAvailable) {
      System.out.println("Now service " +serviceName + " is available");
    } else {
      System.out.println("Now service " + serviceName + " is not available");
    }
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public int getServiceId() {
    return serviceId;
  }

  public String getServiceName() {
    return serviceName;
  }

  public String getServiceType() {
    return serviceType;
  }

  public double getServicePrice() {
    return servicePrice;
  }

  public boolean isPerDay() {
    return perDay;
  }

  public void setServiceId(int serviceId) {
    this.serviceId = serviceId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceId, serviceName, serviceType);
  }
}











