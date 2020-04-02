package com.diligre.repository;

import com.diligre.entity.BillingInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillingInformationRepository extends JpaRepository<BillingInformation,Long> {

    BillingInformation findOneById(Long id);

    void deleteAllByIdIn(List<Long> ids);

}
