package com.jac.suyu.controller;


import com.jac.suyu.entity.Passenger;
import com.jac.suyu.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @GetMapping("/passengers")
    public String listPassengers(Model theModel) {
        List<Passenger> thePassengers = passengerService.getPassengers();
        theModel.addAttribute("passengers", thePassengers);
        return "passengers";
    }

    @GetMapping("/passengers/id")
    public String PassengerById(@RequestParam("passengerId") int passengerId, Model theModel) {
        List<Passenger> thePassengerById = passengerService.getPassengerById(passengerId);
        theModel.addAttribute("passengers", thePassengerById);
        return "passengers";
    }

    @GetMapping("/passengers/find/lastName")
    public String PassengersByLastName(@RequestParam("lastName") String lastName, Model theModel) {
        List<Passenger> thePassengersByLastName = passengerService.getPassengersByLastName(lastName);
        theModel.addAttribute("passengers", thePassengersByLastName);
        return "passengers";
    }

    @GetMapping("passengers/city/same-city")
    public String PassengersBySameDestination(@RequestParam("toCity") String toCity, Model theModel) {
        List<Passenger> thePassengersBySameDestination = passengerService.getPassengersBySameDestination(toCity);
        theModel.addAttribute("passengers", thePassengersBySameDestination);
        return "passengers";
    }

    @GetMapping("passengers/sorted/lastName")
    public String PassengersSortedByLastName(Model theModel) {
        List<Passenger> thePassengers = passengerService.getPassengersSortedByLastName();
        theModel.addAttribute("passengers", thePassengers);
        return "/passengers";
    }

    @GetMapping("passengers/departureDate")
    public String PassengersByDepartureDate(@RequestParam("departureDate") String departureDate, Model theModel) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dDateUtil = df.parse(departureDate);
        java.sql.Date dDate = new java.sql.Date(dDateUtil.getTime());
        List<Passenger> thePassengersByDepartureDate = passengerService.getPassengersByDepartureDate(dDate);
        theModel.addAttribute("passengers", thePassengersByDepartureDate);
        return "passengers";
    }

    @GetMapping("/passengers/find/date/{date}/city/{city}")
    public String PassengersBySameDepartureDateAndDestination(@RequestParam("departureDate") String departureDate,
                                                              @RequestParam("toCity") String toCity, Model theModel) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dDateUtil = df.parse(departureDate);
        java.sql.Date dDate = new java.sql.Date(dDateUtil.getTime());
        List<Passenger> thePassengersBySameDepartureDateAndDestination = passengerService.getPassengersBySameDepartureDateAndDestination(dDate, toCity);
        theModel.addAttribute("passengers", thePassengersBySameDepartureDateAndDestination);
        return "passengers";
    }

    @GetMapping("/passengers/delete")
    public String deletePassenger(@RequestParam("passengerId") int passengerId) {
        passengerService.deletePassengerById(passengerId);
        return "redirect:/api/passengers";
    }
}

