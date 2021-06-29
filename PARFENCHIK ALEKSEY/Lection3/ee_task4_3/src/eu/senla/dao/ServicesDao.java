package eu.senla.dao;

import eu.senla.model.service.Service;
import java.util.TreeMap;

public class ServicesDao {

  final TreeMap<Integer, Service> servicesList = new TreeMap() {
  };

  public TreeMap<Integer, Service> getServicesList() {
    return servicesList;
  }
}
