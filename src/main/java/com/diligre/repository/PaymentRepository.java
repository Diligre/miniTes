package com.diligre.repository;

import com.diligre.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,String> {

    Payment findOneByCardNumber(String id);

    void deleteAllByCardNumberIn(List<String> ids);

}
