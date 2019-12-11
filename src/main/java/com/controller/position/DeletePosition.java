package com.controller.position;

import com.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/position/{id}/delete")
public class DeletePosition {
    private final PositionService positionService;

    public DeletePosition(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public String deletePosition(@PathVariable Integer id) {
        positionService.deleteById(id);
        return "redirect:/view/position";
    }
}

