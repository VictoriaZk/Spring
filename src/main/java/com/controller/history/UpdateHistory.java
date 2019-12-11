package com.controller.history;


import com.model.History;
import com.model.Position;
import com.service.HistoryService;
import com.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/history/{id}/update")
public class UpdateHistory {
    private final HistoryService historyService;
    private final PositionService positionService;

    public UpdateHistory(HistoryService historyService, PositionService positionService) {
        this.historyService = historyService;
        this.positionService = positionService;
    }

    @GetMapping
    public String add(Model model, @PathVariable Integer id) {
        model.addAttribute("history", getHistory(id).orElse(new History()));
        model.addAttribute("position", findAllPositions());
        return "addPosition";
    }

    private List<Position> findAllPositions(){
        return positionService.findAll();
    }
    private Optional<History> getHistory(Integer id) {
        return historyService.findById(id);
    }

    @PostMapping
    public String update(History history) {
        historyService.save(history);
        return "redirect:/view/history";
    }
}