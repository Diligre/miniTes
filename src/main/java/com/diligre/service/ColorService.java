package com.diligre.service;


import com.diligre.entity.Color;
import com.diligre.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorService {

    private final ColorRepository colorRepository;

    public List<Color> getAll() {
        return colorRepository.findAll();
    }

    public void delete(Long id) {
        colorRepository.deleteById(id);
    }

    public Color findOneById(Long id) {
        return colorRepository.findOneById(id);
    }

    @Transactional
    public void bulkDelete(List<Long> ids) {
        colorRepository.deleteAllByIdIn(ids);
    }

    @Transactional
    public List<Color> saveData(List<Color> colors) {
        return colorRepository.saveAll(colors);
    }

}
