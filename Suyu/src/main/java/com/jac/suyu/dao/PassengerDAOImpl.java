package com.jac.suyu.dao;


import com.jac.suyu.entity.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.sql.Date;
import java.util.List;

@Repository
public class PassengerDAOImpl implements PassengerDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Passenger> getPassengers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Passenger> theQuery = currentSession.createQuery("from Passenger order by passengerId");
        List<Passenger> passengers = theQuery.getResultList();
        return passengers;
    }


    @Override
    public List<Passenger> getPassengerById(int passengerId) {
        Session currentSession = sessionFactory.getCurrentSession();
       /* Passenger passenger = (Passenger) currentSession.get(Passenger.class, passengerId);
        return Collections.singletonList(passenger);*/
        Query<Passenger> theQuery = currentSession.createQuery("from Passenger where passengerId=:passengerId");
        theQuery.setParameter("passengerId", passengerId);
        List<Passenger> passengersById = theQuery.list();
        return passengersById;
    }

    @Override
    public List<Passenger> getPassengersByLastName(String lastName) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Passenger> theQuery = currentSession.createQuery("from Passenger where lastName=:lastName");
        theQuery.setParameter("lastName", lastName);
        List<Passenger> passengersByLastName = theQuery.list();
        return passengersByLastName;
    }

    @Override
    public List<Passenger> getPassengersBySameDestination(String toCity) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Passenger> theQuery = currentSession.createQuery("select p from Passenger p join p.flights f where f.toCity=:toCity");
        theQuery.setParameter("toCity", toCity);
        List<Passenger> passengersBySameDestination = theQuery.list();
        return passengersBySameDestination;
    }

    @Override
    public List<Passenger> getPassengersSortedByLastName() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Passenger> theQuery = currentSession.createQuery("from Passenger order by lastName");
        List<Passenger> passengers = theQuery.getResultList();
        return passengers;
    }

    @Override
    public List<Passenger> getPassengersByDepartureDate(Date dDate) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Passenger> theQuery = currentSession.createQuery("select p from Passenger p join p.flights f where f.departureDate=:departureDate");
        theQuery.setParameter("departureDate", dDate);
        List<Passenger> passengers = theQuery.getResultList();
        return passengers;
    }

    @Override
    public List<Passenger> getPassengersBySameDepartureDateAndDestination(Date dDate, String toCity) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Passenger> theQuery = currentSession.createQuery("select p from Passenger p join p.flights f where f.departureDate=:departureDate " +
                "and f.toCity=:toCity");
        theQuery.setParameter("departureDate", dDate);
        theQuery.setParameter("toCity", toCity);
        List<Passenger> passengers = theQuery.getResultList();
        return passengers;
    }

    @Override
    public void deletePassengerById(int passengerId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Passenger> theQuery = currentSession.createQuery("delete from Passenger where passengerId=:passengerId");
        theQuery.setParameter("passengerId", passengerId);
        theQuery.executeUpdate();
    }
}