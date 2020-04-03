package com.diligre.repository;

import com.diligre.entity.Configure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfigureRepository extends JpaRepository<Configure,Long> {

    Configure findOneById(Long id);

    void deleteAllByIdIn(List<Long> ids);

}
