package ru.itpark.larec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.larec.dto.ExperimentDto;
import ru.itpark.larec.entity.ExperimentEntity;
import ru.itpark.larec.service.ExperimentService;

@Controller
@RequestMapping("/")
public class ExperimentController {
    private final ExperimentService experimentService;

    public ExperimentController(ExperimentService experimentService) {
        this.experimentService = experimentService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("experiments", experimentService.findAll());
        return "pages/experiments";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("experiment", experimentService.findById(id));
        return "pages/experiment";
    }

    @GetMapping("/add")
    public String addForm() {
        return "pages/experiment-add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute ExperimentEntity experiment) {
        experimentService.add(experiment);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("experiment", experimentService.findById(id));
        return "pages/experiment-edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable int id, @ModelAttribute ExperimentDto experimentDto) {
        experimentService.update(experimentDto, id);
        return "redirect:/" + id;
    }

    @GetMapping("/{id}/delete")
    public String deleteForm(@PathVariable int id, Model model) {
        model.addAttribute("experiment", experimentService.findById(id));
        return "pages/experiment-delete";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        experimentService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping(value = "/search", params = "name") // Mapping - определяет то, что должно быть в запросе
    public String search(@RequestParam String name, Model model) {
        model.addAttribute("name", name); // чтобы отображать в поле поиска
        model.addAttribute("experiments", experimentService.findByName(name));
        return "pages/experiments";
    }
}
