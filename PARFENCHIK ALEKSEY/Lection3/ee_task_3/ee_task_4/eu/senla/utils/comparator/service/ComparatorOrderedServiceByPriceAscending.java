package eu.senla.utils.comparator.service;

import eu.senla.service.ServiceService.OrderedService;
import java.util.Comparator;

public class ComparatorOrderedServiceByPriceAscending implements Comparator<OrderedService> {

  @Override
  public int compare(OrderedService o1, OrderedService o2) {
    if (o1.getOrderedService().getPrice() < o2.getOrderedService().getPrice()) {
      return -1;
    }
    if (o1.getOrderedService().getPrice() > o2.getOrderedService().getPrice()) {
      return 1;
    }
    return 0;
  }
}
