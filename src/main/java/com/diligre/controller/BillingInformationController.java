package com.diligre.controller;

import com.diligre.dto.BulkDeleteDto;
import com.diligre.entity.BillingInformation;
import com.diligre.entity.Color;
import com.diligre.service.BillingInformationService;
import com.diligre.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/billinginformation")
public class BillingInformationController {

    private final BillingInformationService billingInformationService;

    @Autowired
    public BillingInformationController(BillingInformationService billingInformationService) {
        this.billingInformationService = billingInformationService ;
    }

    @GetMapping
    public List<BillingInformation> allData(){
        return billingInformationService.getAll();
    }

    @GetMapping("/{id}")
    public BillingInformation findOneById(@PathVariable Long id){
        return billingInformationService.findOneById(id);
    }

    @PostMapping
    public List<BillingInformation> saveData(@RequestBody List<BillingInformation> billingInformations){
        return billingInformationService.saveData(billingInformations);
    }

    @PutMapping
    public List<BillingInformation> updateData(@RequestBody List<BillingInformation> billingInformations){
        return billingInformationService.saveData(billingInformations);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        billingInformationService.delete(id);
        return ResponseEntity.ok("deleted");
    }

    @DeleteMapping
    public ResponseEntity<String> bulkDelete(@RequestBody BulkDeleteDto bulkDeleteDto){
        billingInformationService.bulkDelete(bulkDeleteDto.getIds());
        return ResponseEntity.ok("delete"+bulkDeleteDto.getIds());
    }

}
