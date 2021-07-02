package eu.senla.utils.comparator.service;

import eu.senla.service.ServiceService.OrderedService;
import java.util.Comparator;

public class ComparatorOrderedServiceByNameAscending implements Comparator<OrderedService> {

  @Override
  public int compare(OrderedService o1, OrderedService o2) {
    return o1.getOrderedService().getName()
        .compareTo(o2.getOrderedService().getName());
  }
}
