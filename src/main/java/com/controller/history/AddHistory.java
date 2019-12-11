package com.controller.history;

import com.model.History;
import com.model.Position;
import com.service.HistoryService;
import com.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/history/add")
public class AddHistory {
    private final HistoryService historyService;
    private final PositionService positionService;

    public AddHistory(HistoryService historyService, PositionService positionService) {
        this.historyService = historyService;
        this.positionService = positionService;
    }

    @GetMapping
    public String add(Model model) {
        model.addAttribute("history", new History());
        model.addAttribute("position", findAllPositions());
        return "addHistory";
    }

    private List<Position> findAllPositions(){
        return positionService.findAll();
    }

    private Optional<Position> findPosition(Integer id){
        return positionService.findById(id);
    }

    @PostMapping
    public String saveNew(History history) {
        findPosition(history.getPosition().getId()).ifPresent(history::setPosition);
        historyService.save(history);
        return "redirect:/view/history";
    }
}

