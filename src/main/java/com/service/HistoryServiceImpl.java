package com.service;

import com.model.History;
import com.repository.HistoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public History save(History entity) {
        return historyRepository.save(entity);
    }

    @Override
    public Optional<History> findById(Integer id) {
        return historyRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return historyRepository.existsById(id);
    }

    @Override
    public List<History> findAll() {
        return historyRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        historyRepository.deleteById(id);
    }
}
