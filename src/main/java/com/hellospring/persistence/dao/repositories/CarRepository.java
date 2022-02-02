package com.hellospring.persistence.dao.repositories;

import com.hellospring.persistence.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findAllByBrand(String brand);

    List<Car> findAllByBrandAndModelAndSpeedMax(String brand, String model, int speedMax);

    void removeAllByBrand(String brand);
}
