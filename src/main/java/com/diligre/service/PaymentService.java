package com.diligre.service;

import com.diligre.entity.Payment;
import com.diligre.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    public void delete(String cardNumber) {
        paymentRepository.deleteById(cardNumber);
    }

    public Payment findOneByCardNumber(String cardNumber) {
        return paymentRepository.findOneByCardNumber(cardNumber);
    }

    @Transactional
    public void bulkDelete(List<String> cardNumbers) {
        paymentRepository.deleteAllByCardNumberIn(cardNumbers);
    }

    @Transactional
    public List<Payment> saveData(List<Payment> payments) {
        return paymentRepository.saveAll(payments);
    }

}
