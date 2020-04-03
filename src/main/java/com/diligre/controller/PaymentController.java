package com.diligre.controller;

import com.diligre.dto.BulkDeleteDto;
import com.diligre.entity.Payment;
import com.diligre.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> allData(){
        return paymentService.getAll();
    }

    @GetMapping("/{cardNumber}")
    public Payment findOneByCardNumber(@PathVariable String cardNumber){
        return paymentService.findOneByCardNumber(cardNumber);
    }

    @PostMapping
    public List<Payment> saveData(@RequestBody List<Payment> payments){
        return paymentService.saveData(payments);
    }

    @PutMapping
    public List<Payment> updateData(@RequestBody List<Payment> payments){
        return paymentService.saveData(payments);
    }

    @DeleteMapping("/{cardNumber}")
    public ResponseEntity<String> delete(@PathVariable String cardNumber){
        paymentService.delete(cardNumber);
        return ResponseEntity.ok("deleted");
    }

    @DeleteMapping
    public ResponseEntity<String> bulkDelete(@RequestBody BulkDeleteDto bulkDeleteDto){
        paymentService.bulkDelete(bulkDeleteDto.getCardNumbers());
        return ResponseEntity.ok("delete" + bulkDeleteDto.getCardNumbers());
    }

}
