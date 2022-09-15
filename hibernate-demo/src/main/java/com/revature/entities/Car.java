package com.revature.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;

    @Column
    private String make;

    @Column
    private String model;

    @Column
    private String color;

    @Column
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "garage_id", nullable = true)
    private Garage garage;

    public Car() {
    }

    public Car(Integer id, String make, String model, String color, Integer year, Garage garage) {
        this.carId = id;
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.garage = garage;
    }

    public Car(String make, String model, String color, Integer year, Garage garage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.garage = garage;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carId, car.carId) && Objects.equals(make, car.make) && Objects.equals(model, car.model) && Objects.equals(color, car.color) && Objects.equals(year, car.year) && Objects.equals(garage, car.garage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, make, model, color, year);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + carId +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}';
    }
}
