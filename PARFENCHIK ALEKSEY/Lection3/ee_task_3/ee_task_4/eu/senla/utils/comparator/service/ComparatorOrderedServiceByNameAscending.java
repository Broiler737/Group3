package eu.senla.utils.comparator.service;

import eu.senla.model.guest.Guest;

import java.util.Comparator;

public class ComparatorOrderedServiceByNameAscending implements Comparator<Guest.OrderedService> {

  @Override
  public int compare(Guest.OrderedService o1, Guest.OrderedService o2) {
    return o1.getOrderedService().getServiceName()
        .compareTo(o2.getOrderedService().getServiceName());
  }
}
