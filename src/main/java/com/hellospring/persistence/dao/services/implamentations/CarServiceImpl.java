package com.hellospring.persistence.dao.services.implamentations;

import com.google.common.collect.Lists;
import com.hellospring.persistence.dao.services.interfaces.CarService;
import com.hellospring.persistence.dao.repositories.CarRepository;
import com.hellospring.persistence.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository repository;

    @PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
    @Override
    public List<Car> findAll() throws InterruptedException {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public Car addCar(Car car) {
        return repository.save(car);
    }

    @Override
    public List<Car> findAllByBrand(String brand) {
        return Lists.newArrayList(repository.findAllByBrand(brand));
    }

    @Override
    public List<Car> findAllByBrandAndModelAndSpeedMax(String brand, String model, int speedMax) {
        return Lists.newArrayList(repository.findAllByBrandAndModelAndSpeedMax(brand, model, speedMax));
    }

    @Override
    public void removeById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void removeAllByBrand(String brand) {
        repository.removeAllByBrand(brand);
    }

    @Autowired
    public void setRepository(CarRepository repository) {
        this.repository = repository;
    }
}
