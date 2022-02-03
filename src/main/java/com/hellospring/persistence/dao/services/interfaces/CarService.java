package com.hellospring.persistence.dao.services.interfaces;

import com.hellospring.persistence.model.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll() throws InterruptedException;

    Car addCar(Car car);

    List<Car> findAllByBrand(String brand);

    List<Car> findAllByBrandAndModelAndSpeedMax(String brand, String model, int speedMax);

    void removeById(long id);

    void removeAllByBrand(String brand);
}
