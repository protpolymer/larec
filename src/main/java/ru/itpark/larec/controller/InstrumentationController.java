package ru.itpark.larec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.larec.dto.InstrumentationDto;
import ru.itpark.larec.service.InstrumentationService;

@Controller
@RequestMapping
public class InstrumentationController {
    private final InstrumentationService instrumentationService;

    public InstrumentationController(InstrumentationService instrumentationService) {
        this.instrumentationService = instrumentationService;
    }

    @GetMapping("/instrumentation-add")
    public String addInstrumentationForm() {
        return "pages/instrumentation-add";
    }

    @PostMapping("/instrumentation-add")
    public String addReagent(@ModelAttribute InstrumentationDto instrumentationDto) {
        instrumentationService.add(instrumentationDto);
        return "redirect:/" + instrumentationDto.getExperimentId();
    }

    @PostMapping("/instrumentation/{id}")
    public String save(@ModelAttribute InstrumentationDto instrumentationDto, @PathVariable int id) {
        instrumentationService.updateById(instrumentationDto, id);
        return "redirect:/" + instrumentationDto.getExperimentId();
    }

    @GetMapping("/instrumentation/{id}")
    public String getInstrumentationById(@PathVariable int id, Model model) {
        model.addAttribute("instrumentation", instrumentationService.findById(id));
        return "pages/instrumentation";
    }

    @GetMapping("/instrumentation/{id}/delete")
    public String deleteInstrumentationForm(@PathVariable int id, Model model) {
        model.addAttribute("instrumentation", instrumentationService.findById(id));
        return "pages/instrumentation-delete";
    }

    @PostMapping("/instrumentation/{id}/delete")
    public String deleteInstrumentation(@PathVariable int id) {
        int experimentId = instrumentationService.findById(id).getExperiment().getId();
        instrumentationService.deleteById(id);
        return "redirect:/" + experimentId;
    }
}
