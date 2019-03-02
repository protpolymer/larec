package ru.itpark.larec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.larec.dto.ReagentDto;
import ru.itpark.larec.service.ReagentService;

@Controller
@RequestMapping
public class ReagentController {
    private final ReagentService reagentService;

    public ReagentController(ReagentService reagentService) {
        this.reagentService = reagentService;
    }

    @GetMapping("/reagent-add")
    public String addReagentForm() {
        return "pages/reagent-add";
    }

    @PostMapping("/reagent-add")
    public String addReagent(@ModelAttribute ReagentDto reagentDto) {
        reagentService.add(reagentDto);
        return "redirect:/" + reagentDto.getExperimentId();
    }

    @PostMapping("/reagent/{id}")
    public String save(@ModelAttribute ReagentDto reagentDto, @PathVariable int id) {
        reagentService.updateById(reagentDto, id);
        return "redirect:/" + reagentDto.getExperimentId();
    }

    @GetMapping("/reagent/{id}")
    public String getReagentById(@PathVariable int id, Model model) {
        model.addAttribute("reagent", reagentService.findById(id));
        return "pages/reagent";
    }

    @GetMapping("/reagent/{id}/delete")
    public String deleteReagentForm(@PathVariable int id, Model model) {
        model.addAttribute("reagent", reagentService.findById(id));
        return "pages/reagent-delete";
    }

    @PostMapping("/reagent/{id}/delete")
    public String deleteReagent(@PathVariable int id) {
        int experimentId = reagentService.findById(id).getExperiment().getId();
        reagentService.deleteById(id);
        return "redirect:/" + experimentId;
    }
}
