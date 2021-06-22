package eu.senla.utils.comparator.service;

import eu.senla.model.service.Service;
import java.util.Comparator;

public class ComparatorServiceByTypeAscending implements Comparator<Service> {

  public ComparatorServiceByTypeAscending() {
  }

  @Override
  public int compare(Service o1, Service o2) {
    if (o1.hashCode() < o2.hashCode()) {
      return -1;
    }
    if (o1.hashCode() > o2.hashCode()) {
      return 1;
    }
    return 0;
  }
}
