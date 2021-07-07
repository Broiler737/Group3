package eu.senla.utils.comparator.service;

import eu.senla.model.service.Service;
import java.util.Comparator;

public class ComparatorServiceByPriceDescending implements Comparator<Service> {

  public ComparatorServiceByPriceDescending() {
  }

  @Override
  public int compare(Service o1, Service o2) {
    if (o1.getPrice() < o2.getPrice()) {
      return 1;
    }
    if (o1.getPrice() > o2.getPrice()) {
      return -1;
    }
    return 0;
  }
}
