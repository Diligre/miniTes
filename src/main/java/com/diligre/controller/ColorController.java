package com.diligre.controller;

import com.diligre.dto.BulkDeleteDto;
import com.diligre.entity.Color;
import com.diligre.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/color")
public class ColorController {

    private final ColorService colorService;

    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping
    public List<Color> allData(){
        return colorService.getAll();
    }

    @GetMapping("/{id}")
    public Color findOneById(@PathVariable Long id){
        return colorService.findOneById(id);
    }

    @PostMapping
    public List<Color> saveData(@RequestBody List<Color> colors){
        return colorService.saveData(colors);
    }

    @PutMapping
    public List<Color> updateData(@RequestBody List<Color> colors){
        return colorService.saveData(colors);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        colorService.delete(id);
        return ResponseEntity.ok("deleted");
    }

    @DeleteMapping
    public ResponseEntity<String> bulkDelete(@RequestBody BulkDeleteDto bulkDeleteDto){
            colorService.bulkDelete(bulkDeleteDto.getIds());
            return ResponseEntity.ok("delete"+bulkDeleteDto.getIds());
    }

}
