package com.jac.suyu.dao;

import com.jac.suyu.entity.Passenger;

import java.sql.Date;
import java.util.List;

public interface PassengerDAO {
    public List<Passenger> getPassengers();

    public List<Passenger> getPassengerById(int passengerId);

    public List<Passenger> getPassengersByLastName(String lastName);

    public List<Passenger> getPassengersBySameDestination(String toCity);

    public List<Passenger> getPassengersSortedByLastName();

    public List<Passenger> getPassengersByDepartureDate(Date dDate);

    public List<Passenger> getPassengersBySameDepartureDateAndDestination(Date dDate, String toCity);

    public void deletePassengerById(int passengerId);
}
