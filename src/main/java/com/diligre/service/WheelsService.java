package com.diligre.service;

import com.diligre.entity.Wheels;
import com.diligre.repository.WheelsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WheelsService {

    private final WheelsRepository wheelsRepository;

    public List<Wheels> getAll() {
        return wheelsRepository.findAll();
    }

    public void delete(Long id) {
        wheelsRepository.deleteById(id);
    }

    public Wheels findOneById(Long id) {
        return wheelsRepository.findOneById(id);
    }

    @Transactional
    public void bulkDelete(List<Long> ids) {
        wheelsRepository.deleteAllByIdIn(ids);
    }

    @Transactional
    public List<Wheels> saveData(List<Wheels> wheels) {
        return wheelsRepository.saveAll(wheels);
    }

}
