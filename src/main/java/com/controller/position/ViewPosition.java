package com.controller.position;

import com.model.Position;
import com.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/view/position")
public class ViewPosition {
    private final PositionService positionService;

    @Autowired
    public ViewPosition(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public String viewPosition(Model model) {
        List<Position> positions = positionService.findAll();
        model.addAttribute("positions", positions);
        return "viewPosition";
    }
}