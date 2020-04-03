package com.diligre.controller;


import com.diligre.dto.BulkDeleteDto;
import com.diligre.entity.Interior;
import com.diligre.entity.Model;
import com.diligre.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/model")
public class ModelController {

    private ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public List<Model> allData(){
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    public Model findOneById(@PathVariable Long id){
        return modelService.findOneById(id);
    }

    @PostMapping
    public List<Model> saveData(@RequestBody List<Model> models){
        return modelService.saveData(models);
    }

    @PutMapping
    public List<Model> updateData(@RequestBody List<Model> models){
        return modelService.saveData(models);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        modelService.delete(id);
        return ResponseEntity.ok("deleted");
    }

    @DeleteMapping
    public ResponseEntity<String> bulkDelete(@RequestBody BulkDeleteDto bulkDeleteDto){
        modelService.bulkDelete(bulkDeleteDto.getIds());
        return ResponseEntity.ok("delete" + bulkDeleteDto.getIds());
    }

}
