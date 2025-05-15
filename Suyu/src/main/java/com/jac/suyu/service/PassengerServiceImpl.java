package com.jac.suyu.service;


import com.jac.suyu.dao.PassengerDAO;
import com.jac.suyu.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private PassengerDAO passengerDAO;

    @Override
    @Transactional
    public List<Passenger> getPassengers() {
        return passengerDAO.getPassengers();
    }

    @Override
    @Transactional
    public List<Passenger> getPassengerById(int passengerId) {
        return passengerDAO.getPassengerById(passengerId);
    }

    @Override
    @Transactional
    public List<Passenger> getPassengersByLastName(String lastName) {
        return passengerDAO.getPassengersByLastName(lastName);
    }

    @Override
    @Transactional
    public List<Passenger> getPassengersBySameDestination(String toCity) {
        return passengerDAO.getPassengersBySameDestination(toCity);
    }

    @Override
    @Transactional
    public List<Passenger> getPassengersSortedByLastName() {
        return passengerDAO.getPassengersSortedByLastName();
    }

    @Override
    @Transactional
    public List<Passenger> getPassengersByDepartureDate(Date dDate) {
        return passengerDAO.getPassengersByDepartureDate(dDate);
    }

    @Override
    @Transactional
    public List<Passenger> getPassengersBySameDepartureDateAndDestination(Date dDate, String toCity) {
        return passengerDAO.getPassengersBySameDepartureDateAndDestination(dDate, toCity);
    }

    @Override
    @Transactional
    public void deletePassengerById(int passengerId) {
        passengerDAO.deletePassengerById(passengerId);
    }
}
