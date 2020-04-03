package com.diligre.service;

import com.diligre.entity.Configure;
import com.diligre.repository.ConfigureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfigureService {

    private final ConfigureRepository configureRepository;

    public List<Configure> getAll() {
        return configureRepository.findAll();
    }

    public void delete(Long id) {
        configureRepository.deleteById(id);
    }

    public Configure findOneById(Long id) {
        return configureRepository.findOneById(id);
    }

    @Transactional
    public void bulkDelete(List<Long> ids) {
        configureRepository.deleteAllByIdIn(ids);
    }

    @Transactional
    public List<Configure> saveData(List<Configure> configures) {
        return configureRepository.saveAll(configures);
    }

}
