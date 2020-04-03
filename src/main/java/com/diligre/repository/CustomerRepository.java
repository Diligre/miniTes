package com.diligre.repository;

import com.diligre.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findOneById(Long id);

    void deleteAllByIdIn(List<Long> ids);

}
