package com.controller.history;

import com.model.History;
import com.service.HistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/view/history")
public class ViewHistory {
    private final HistoryService historyService;

    public ViewHistory(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public String viewHistory(Model model) {
        List<History> histories = historyService.findAll();
        model.addAttribute("histories", histories);
        return "viewHistory";
    }
}
