package com.diligre.repository;

import com.diligre.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model,Long> {

    Model findOneById(Long id);

    void deleteAllByIdIn(List<Long> ids);

}
