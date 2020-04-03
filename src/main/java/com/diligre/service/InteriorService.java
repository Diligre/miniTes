package com.diligre.service;

import com.diligre.entity.Interior;
import com.diligre.repository.InteriorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InteriorService {

    private final InteriorRepository interiorRepository;

    public List<Interior> getAll() {
        return interiorRepository.findAll();
    }

    public void delete(Long id) {
        interiorRepository.deleteById(id);
    }

    public Interior findOneById(Long id) {
        return interiorRepository.findOneById(id);
    }

    @Transactional
    public void bulkDelete(List<Long> ids) {
        interiorRepository.deleteAllByIdIn(ids);
    }

    @Transactional
    public List<Interior> saveData(List<Interior> interiors) {
        return interiorRepository.saveAll(interiors);
    }

}
