package eu.senla.utils.comparator.service;

import eu.senla.service.Service;
import java.util.Comparator;

public class ComparatorServiceByPriceDescending implements Comparator<Service> {

  public ComparatorServiceByPriceDescending() {
  }

  @Override
  public int compare(Service o1, Service o2) {
    if (o1.getServicePrice() < o2.getServicePrice()) {
      return 1;
    }
    if (o1.getServicePrice() > o2.getServicePrice()) {
      return -1;
    }
    return 0;
  }
}
