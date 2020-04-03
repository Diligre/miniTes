package com.diligre.service;

import com.diligre.entity.Model;
import com.diligre.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelService  {

    private final ModelRepository modelRepository;

    public List<Model> getAll() {
        return modelRepository.findAll();
    }

    public void delete(Long id) {
        modelRepository.deleteById(id);
    }

    public Model findOneById(Long id) {
        return modelRepository.findOneById(id);
    }

    @Transactional
    public void bulkDelete(List<Long> ids) {
        modelRepository.deleteAllByIdIn(ids);
    }

    @Transactional
    public List<Model> saveData(List<Model> models) {
        return modelRepository.saveAll(models);
    }

}
