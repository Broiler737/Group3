package eu.senla.model.service;


import java.util.Objects;

public class Service {

  private int id;
  private final String name;
  private final String type;
  private double price;
 // private boolean isAvailable;
  private final boolean perDay;

  public Service(String name, Double price, String type, Boolean perDay) {
    this.name = name;
    this.price = price;
    this.type = type;
    this.perDay = perDay;
  //  this.isAvailable = true;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setPrice(double price) {
    this.price = price;
  }

 /* public void setAvailable(boolean available) {
    this.isAvailable = available;
  }*/

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public double getPrice() {
    return price;
  }

  public boolean isPerDay() {
    return perDay;
  }

  /*public boolean isAvailable() {
    return isAvailable;
  }*/


  @Override
  public int hashCode() {
    return Objects.hash(id, name, type);
  }
}











