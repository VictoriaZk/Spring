package com.service;

import com.model.Position;
import com.repository.PositionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        positionRepository.deleteById(id);
    }

    @Override
    public Position save(Position entity) {
        return positionRepository.save(entity);
    }

    @Override
    public Optional<Position> findById(Integer id) {
        return positionRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return positionRepository.existsById(id);
    }


}
