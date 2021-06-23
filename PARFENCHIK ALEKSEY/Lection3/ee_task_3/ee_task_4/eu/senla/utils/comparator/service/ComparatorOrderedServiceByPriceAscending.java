package eu.senla.utils.comparator.service;

import eu.senla.model.guest.Guest;

import java.util.Comparator;

public class ComparatorOrderedServiceByPriceAscending implements Comparator<Guest.OrderedService> {

  @Override
  public int compare(Guest.OrderedService o1, Guest.OrderedService o2) {
    if (o1.getOrderedService().getServicePrice() < o2.getOrderedService().getServicePrice()) {
      return -1;
    }
    if (o1.getOrderedService().getServicePrice() > o2.getOrderedService().getServicePrice()) {
      return 1;
    }
    return 0;
  }
}
