package com.controller.history;

import com.service.HistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/history/{id}/delete")
public class DeleteHistory {
    private final HistoryService historyService;

    public DeleteHistory(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public String deleteHistory(@PathVariable Integer id) {
        historyService.deleteById(id);
        return "redirect:/view/history";
    }
}

