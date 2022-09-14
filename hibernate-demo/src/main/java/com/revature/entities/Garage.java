package com.revature.entities;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "garages")
public class Garage {

    @Id
    @Column(name = "garage_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer garageId;

    @Column
    private String owner;

    @OneToMany(mappedBy = "garage")
    @Cascade({CascadeType.SAVE_UPDATE})//note this is NOT from the javax.persistence package
    private List<Car> cars;

    public Garage() {
    }

    public Garage(Integer garageId, String owner) {
        this.garageId = garageId;
        this.owner = owner;
        this.cars = new LinkedList<>();
    }

    public Garage(String owner) {
        this.owner = owner;
        this.cars = new LinkedList<>();
    }

    public Integer getGarageId() {
        return garageId;
    }

    public void setGarageId(Integer garageId) {
        this.garageId = garageId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.equals(garageId, garage.garageId) && Objects.equals(owner, garage.owner) && Objects.equals(cars, garage.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(garageId, owner, cars);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "garageId=" + garageId +
                ", owner='" + owner + '\'' +
                ", cars=" + cars +
                '}';
    }
}
