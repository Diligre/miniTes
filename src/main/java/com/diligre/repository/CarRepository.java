package com.diligre.repository;

import com.diligre.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {

    Car findOneById(Long id);

    void deleteAllByIdIn(List<Long> ids);

}
