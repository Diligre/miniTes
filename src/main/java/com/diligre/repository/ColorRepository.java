package com.diligre.repository;

import com.diligre.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color,Long> {

    Color findOneById(Long id);

    void deleteAllByIdIn(List<Long> ids);

}
