package ru.itpark.larec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.larec.dto.ProductDto;
import ru.itpark.larec.service.ProductService;

@Controller
@RequestMapping
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product-add")
    public String addProductForm() {
        return "pages/product-add";
    }

    @PostMapping("/product-add")
    public String addProduct(@ModelAttribute ProductDto productDto) {
        productService.add(productDto);
        return "redirect:/" + productDto.getExperimentId();
    }

    @PostMapping("/product/{id}")
    public String save(@ModelAttribute ProductDto productDto, @PathVariable int id) {
        productService.updateById(productDto, id);
        return "redirect:/" + productDto.getExperimentId();
    }

    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "pages/product";
    }

    @GetMapping("/product/{id}/delete")
    public String deleteProductForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "pages/product-delete";
    }

    @PostMapping("/product/{id}/delete")
    public String deleteProduct(@PathVariable int id) {
        int experimentId = productService.findById(id).getExperiment().getId();
        productService.deleteById(id);
        return "redirect:/" + experimentId;
    }
}
