package com.diligre.controller;

import com.diligre.dto.BulkDeleteDto;
import com.diligre.entity.Configure;
import com.diligre.service.ConfigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/configure")
public class ConfigureController  {

    private ConfigureService configureService;

    @Autowired
    public ConfigureController(ConfigureService configureService) {
        this.configureService = configureService;
    }

    @GetMapping
    public List<Configure> allData(){
        return configureService.getAll();
    }

    @GetMapping("/{id}")
    public Configure findOneById(@PathVariable Long id){
        return configureService.findOneById(id);
    }

    @PostMapping
    public List<Configure> saveData(@RequestBody List<Configure> configures){
        return configureService.saveData(configures);
    }

    @PutMapping
    public List<Configure> updateData(@RequestBody List<Configure> configures){
        return configureService.saveData(configures);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        configureService.delete(id);
        return ResponseEntity.ok("deleted");
    }

    @DeleteMapping
    public ResponseEntity<String> bulkDelete(@RequestBody BulkDeleteDto bulkDeleteDto){
        configureService.bulkDelete(bulkDeleteDto.getIds());
        return ResponseEntity.ok("delete"+bulkDeleteDto.getIds());
    }

}
