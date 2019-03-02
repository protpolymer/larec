package ru.itpark.larec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.larec.dto.ResearcherDto;
import ru.itpark.larec.service.ResearcherService;

@Controller
@RequestMapping()
public class ResearcherController {
    private final ResearcherService researcherService;

    public ResearcherController(ResearcherService researcherService) {
        this.researcherService = researcherService;
    }

    @GetMapping("/researcher-add")
    public String addResearcherForm() {
        return "pages/researcher-add";
    }

    @PostMapping("/researcher-add")
    public String addResearcher(@ModelAttribute ResearcherDto researcherDto) {
        researcherService.add(researcherDto);
        return "redirect:/" + researcherDto.getExperimentId();
    }

    @PostMapping("/researcher/{id}")
    public String save(@ModelAttribute ResearcherDto researcherDto, @PathVariable int id) {
        researcherService.updateById(researcherDto, id);
        return "redirect:/" + researcherDto.getExperimentId();
    }

    @GetMapping("/researcher/{id}")
    public String getResearcherById(@PathVariable int id, Model model) {
        model.addAttribute("researcher", researcherService.findById(id));
        return "pages/researcher";
    }

    @GetMapping("/researcher/{id}/delete")
    public String deleteResearcherForm(@PathVariable int id, Model model) {
        model.addAttribute("researcher", researcherService.findById(id));
        return "pages/researcher-delete";
    }

    @PostMapping("/researcher/{id}/delete")
    public String deleteResearcher(@PathVariable int id) {
        int experimentId = researcherService.findById(id).getExperiment().getId();
        researcherService.deleteById(id);
        return "redirect:/" + experimentId;
    }
}
