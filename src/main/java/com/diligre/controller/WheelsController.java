package com.diligre.controller;

import com.diligre.dto.BulkDeleteDto;
import com.diligre.entity.Model;
import com.diligre.entity.Wheels;
import com.diligre.service.WheelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/wheels")
public class WheelsController {

    private WheelsService wheelsService;

    @Autowired
    public WheelsController(WheelsService wheelsService) {
        this.wheelsService = wheelsService;
    }

    @GetMapping
    public List<Wheels> allData(){
        return wheelsService.getAll();
    }

    @GetMapping("/{id}")
    public Wheels findOneById(@PathVariable Long id){
        return wheelsService.findOneById(id);
    }

    @PostMapping
    public List<Wheels> saveData(@RequestBody List<Wheels> wheels){
        return wheelsService.saveData(wheels);
    }

    @PutMapping
    public List<Wheels> updateData(@RequestBody List<Wheels> wheels){
        return wheelsService.saveData(wheels);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        wheelsService.delete(id);
        return ResponseEntity.ok("deleted");
    }

    @DeleteMapping
    public ResponseEntity<String> bulkDelete(@RequestBody BulkDeleteDto bulkDeleteDto){
        wheelsService.bulkDelete(bulkDeleteDto.getIds());
        return ResponseEntity.ok("delete" + bulkDeleteDto.getIds());
    }

}
