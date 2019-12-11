package com.controller.position;

import com.model.Position;
import com.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping(value = "/position/{id}/update")
public class UpdatePosition {
    private final PositionService positionService;

    @Autowired
    public UpdatePosition(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public String add(Model model, @PathVariable Integer id) {
        model.addAttribute("position", getPosition(id).orElse(new Position()));
        return "addPosition";
    }

    private Optional<Position> getPosition(Integer id) {
        return positionService.findById(id);
    }

    @PostMapping
    public String update(Position position) {
        positionService.save(position);
        return "redirect:/view/position";
    }
}
