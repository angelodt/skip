package br.com.angelodt.skip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.angelodt.skip.api.dto.ProductDTO;
import br.com.angelodt.skip.service.ProductService;

@RestController
@RequestMapping("/api/v1/Product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.getAll();
    };
    
    @GetMapping("/search/{searchText}")
    public List<ProductDTO> search(@PathVariable String searchText) {
        return productService.search(searchText);
    }
    
    @GetMapping("/{productId}")
    public ProductDTO getProduct(@PathVariable Long productId) {
        return productService.getProduct(productId);
    }
}
