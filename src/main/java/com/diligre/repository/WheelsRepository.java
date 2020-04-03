package com.diligre.repository;

import com.diligre.entity.Wheels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WheelsRepository extends JpaRepository<Wheels,Long> {

    Wheels findOneById(Long id);

    void deleteAllByIdIn(List<Long> ids);

}
