package eu.senla.dao;

import eu.senla.model.service.Service;
import java.util.TreeMap;

public class Services {

  final TreeMap<Integer, Service> services = new TreeMap<Integer, Service>() {
  };

  public TreeMap<Integer, Service> getServices() {
    return services;
  }
}
