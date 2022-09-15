package com.revature;


import com.revature.entities.Car;
import com.revature.entities.Garage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(Car.class);
        config.addAnnotatedClass(Garage.class);
        Session session = config.buildSessionFactory().openSession();

        Garage lukesGarage = new Garage("Luke Harris");
        Car lambo = new Car("Lamorghini", "Huracan", "red", 2022, lukesGarage);
        lukesGarage.getCars().add(lambo);
        Car pinto = new Car("Ford", "Pinto", "wood paneled mustard", 1978, lukesGarage);
        lukesGarage.getCars().add(pinto);

        Garage kylesGarage = new Garage("Kyle Plummer");
        Car honda = new Car("Honda", "HR-V", "blue", 2015, kylesGarage);
        kylesGarage.getCars().add(honda);


        Garage nygilsGarage = new Garage("Nygil Nettles");
        Car beater = new Car("Geo", "Metro", "red", 1991, nygilsGarage);
        nygilsGarage.getCars().add(beater);



        Transaction tx = session.beginTransaction();
        //note: no need to save the cars individually now that the cascade behavior is set properly in the entity class
        //Do not confuse this with the cascade behavior annotations in the javax.persistence package, the cascade behavior here
        //must use the annotation from the hibernate.annotations package
        session.save(lukesGarage);
        session.save(kylesGarage);
        session.save(nygilsGarage);
        tx.commit();



        //Note that for queries we do not need a transaction.
        // Transactions are for making changes to the database.
        //tx = session.beginTransaction();
        Garage result = session.get(Garage.class, 1);
        //tx.commit();

        System.out.println("Garage #1: " + result);

        //Criteria Query:
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Garage> criteriaQuery = builder.createQuery(Garage.class);
        Root<Garage> garageRoot = criteriaQuery.from(Garage.class);
        Join<Garage, Car> joinCars = garageRoot.join("cars");

        criteriaQuery.select(garageRoot).where(builder.greaterThan(joinCars.get("year"), 2015));

        List<Garage> garagesWithNewCars =  session.createQuery(criteriaQuery).getResultList();
        System.out.println("Garages with new cars: " + garagesWithNewCars);


        //Native SQL query:
        TypedQuery<Car> nativeQuery = session.createNativeQuery("SELECT * FROM cars WHERE color = :color", Car.class);
        nativeQuery.setParameter("color", "red");
        List<Car> redCars = nativeQuery.getResultList();

        System.out.println("Red cars: " + redCars);


        //HQL query:
        Query hqlQuery = session.createQuery("FROM Car as c INNER JOIN Garage as g ON c.garage = g.garageId");
        List<Object[]> list = hqlQuery.getResultList();
        for(Object[] row : list) {
            System.out.println(((Car)row[0]).getModel() + " belongs to: " + ((Garage)row[1]).getOwner());

        }

    }
}
