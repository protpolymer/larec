package ru.itpark.larec.advice;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itpark.larec.exception.*;

@ControllerAdvice
public class AppControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ExperimentNotFoundException.class)
    public String handleExperimentNotFound(Model model) {
        model.addAttribute("message", "Experiment not found");
        return "error";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(InstrumentationNotFoundException.class)
    public String handleInstrumentationNotFound(Model model) {
        model.addAttribute("message", "Instrumentation not found");
        return "error";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public String handleProductNotFound(Model model) {
        model.addAttribute("message", "Product not found");
        return "error";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ReagentNotFoundException.class)
    public String handleReagentNotFound(Model model) {
        model.addAttribute("message", "Reagent not found");
        return "error";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResearcherNotFoundException.class)
    public String handleResearcherNotFound(Model model) {
        model.addAttribute("message", "Researcher not found");
        return "error";
    }
}
