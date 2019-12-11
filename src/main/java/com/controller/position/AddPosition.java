package com.controller.position;

import com.model.Position;
import com.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/add/position")
public class AddPosition {
    private final PositionService positionService;

    public AddPosition(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public String add(Model model) {
        model.addAttribute("position", new Position());
        return "addPosition";
    }

    @PostMapping
    public String saveNew(Position position) {
        positionService.save(position);
        return "redirect:/";
    }
}
