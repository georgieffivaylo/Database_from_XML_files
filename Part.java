package com.softuni.xml.entities;

import javax.persistence.*;
import java.math.*;
import java.util.*;

@Entity
@Table(name = "parts")
public class Part extends BaseEntity{

    private String name;
    private BigDecimal price;
    private Integer quantity;
    private Set<Car> cars;
    private Supplier supplier;

    public Part() {
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @ManyToMany
    @JoinTable(name = "parts_cars", joinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"))
    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
