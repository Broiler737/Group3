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

  public void setServiceId(int serviceId) {
    this.serviceId = serviceId;
  }

  public void setServicePrice(double servicePrice) {
    this.servicePrice = servicePrice;
  }

  public void setAvailable(boolean available) {
    this.isAvailable = available;
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

  public boolean isAvailable() {
    return isAvailable;
  }


  @Override
  public int hashCode() {
    return Objects.hash(serviceId, serviceName, serviceType);
  }
}











