package ru.itpark.larec.service;

import org.springframework.stereotype.Service;
import ru.itpark.larec.dto.ProductDto;
import ru.itpark.larec.entity.ProductEntity;
import ru.itpark.larec.exception.ProductNotFoundException;
import ru.itpark.larec.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ExperimentService experimentService;

    public ProductService(ProductRepository productRepository, ExperimentService experimentService) {
        this.productRepository = productRepository;
        this.experimentService = experimentService;
    }
    public void add(ProductDto item) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setExperiment(experimentService.findById(item.getExperimentId()));
        productEntity.setName(item.getName());
        productEntity.setMolecularWeight(item.getMolecularWeight());
        productEntity.setFormula(item.getFormula());
        productEntity.setAmountGram(item.getAmountGram());
        productEntity.setLinkForDescription(item.getLinkForDescription());
        productRepository.save(productEntity);
    }

    public ProductEntity findById(int id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    public void updateById(ProductDto productDto, int id) {
        ProductEntity product = productRepository.findById(id).orElseThrow();
        product.setName(productDto.getName());
        product.setLinkForDescription(productDto.getLinkForDescription());
        product.setAmountGram(productDto.getAmountGram());
        product.setFormula(productDto.getFormula());
        product.setMolecularWeight(productDto.getMolecularWeight());
        productRepository.save(product);
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
