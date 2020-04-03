package com.diligre.controller;


import com.diligre.dto.BulkDeleteDto;
import com.diligre.entity.Configure;
import com.diligre.entity.Interior;
import com.diligre.service.InteriorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/interior")
public class InteriorController {

    private InteriorService interiorService;

    @Autowired
    public InteriorController(InteriorService interiorService) {
        this.interiorService = interiorService;
    }

    @GetMapping
    public List<Interior> allData(){
        return interiorService.getAll();
    }

    @GetMapping("/{id}")
    public Interior findOneById(@PathVariable Long id){
        return interiorService.findOneById(id);
    }

    @PostMapping
    public List<Interior> saveData(@RequestBody List<Interior> interiors){
        return interiorService.saveData(interiors);
    }

    @PutMapping
    public List<Interior> updateData(@RequestBody List<Interior> interiors){
        return interiorService.saveData(interiors);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        interiorService.delete(id);
        return ResponseEntity.ok("deleted");
    }

    @DeleteMapping
    public ResponseEntity<String> bulkDelete(@RequestBody BulkDeleteDto bulkDeleteDto){
        interiorService.bulkDelete(bulkDeleteDto.getIds());
        return ResponseEntity.ok("delete" + bulkDeleteDto.getIds());
    }

}
