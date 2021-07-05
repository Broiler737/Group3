package eu.senla.service;

import java.util.Objects;

public class Service {

  private int serviceId;
  private final String serviceName;
  private final String serviceType;
  private double servicePrice;
  private final boolean perDay;

  public Service(String serviceName, Double servicePrice, String serviceType, Boolean perDay) {
    this.serviceName = serviceName;
    this.servicePrice = servicePrice;
    this.serviceType = serviceType;
    this.perDay = perDay;
  }

  public void changeServicePrice(Double servicePrice) {
    this.servicePrice = servicePrice;
    System.out.println("Now " + serviceName + " price is " + servicePrice + "$");
  }

  public int getServiceId() {
    return serviceId;
  }

  public void setServiceId(int serviceId) {
    this.serviceId = serviceId;
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

  @Override
  public int hashCode() {
    return Objects.hash(serviceId, serviceName, serviceType);
  }
}











