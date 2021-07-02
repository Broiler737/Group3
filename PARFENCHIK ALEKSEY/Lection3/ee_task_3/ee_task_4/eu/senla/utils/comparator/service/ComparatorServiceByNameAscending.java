package eu.senla.utils.comparator.service;

import eu.senla.model.service.Service;
import java.util.Comparator;

public class ComparatorServiceByNameAscending implements Comparator<Service> {

  @Override
  public int compare(Service o1, Service o2) {
    return o1.getName().compareTo(o2.getName());
  }
}
