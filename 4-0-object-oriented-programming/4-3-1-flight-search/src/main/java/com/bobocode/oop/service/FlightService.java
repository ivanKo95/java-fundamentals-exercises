package com.bobocode.oop.service;

import static java.util.stream.Collectors.toList;

import com.bobocode.oop.data.FlightDao;

import java.util.List;

/**
 * {@link FlightService} provides an API that allows to manage flight numbers
 * <p>
 * todo: 1. Using {@link com.bobocode.oop.data.FlightDao} implement method {@link FlightService#registerFlight(String)}
 * todo: 2. Using {@link com.bobocode.oop.data.FlightDao} implement method {@link FlightService#searchFlights(String)}
 */
public class FlightService {

  private final FlightDao flightDao = new FlightDao();

  /**
   * Adds a new flight number
   *
   * @param flightNumber a flight number to add
   * @return {@code true} if a flight number was added, {@code false} otherwise
   */
  public boolean registerFlight(String flightNumber) {
    return flightDao.register(flightNumber);
  }

  /**
   * Returns all flight numbers that contains a provided key.
   *
   * @param query a search query
   * @return a list of found flight numbers
   */
  public List<String> searchFlights(String query) {
    var allFlights = flightDao.findAll();

    return allFlights.stream()
        .filter(flight -> flight.contains(query))
        .collect(toList());
  }
}
