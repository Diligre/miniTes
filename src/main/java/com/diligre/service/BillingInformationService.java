package com.diligre.service;

import com.diligre.entity.BillingInformation;
import com.diligre.entity.Color;
import com.diligre.repository.BillingInformationRepository;
import com.diligre.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillingInformationService {

    private final BillingInformationRepository billingInformationRepository;

    public List<BillingInformation> getAll() {
        return billingInformationRepository.findAll();
    }

    public void delete(Long id) {
        billingInformationRepository.deleteById(id);
    }

    public BillingInformation findOneById(Long id) {
        return billingInformationRepository.findOneById(id);
    }

    @Transactional
    public void bulkDelete(List<Long> ids) {
        billingInformationRepository.deleteAllByIdIn(ids);
    }

    @Transactional
    public List<BillingInformation> saveData(List<BillingInformation> billingInformations) {
        return billingInformationRepository.saveAll(billingInformations);
    }

}
