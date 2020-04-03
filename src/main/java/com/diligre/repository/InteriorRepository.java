package com.diligre.repository;

import com.diligre.entity.Interior;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InteriorRepository extends JpaRepository<Interior,Long> {

    Interior findOneById(Long id);

    void deleteAllByIdIn(List<Long> ids);

}
