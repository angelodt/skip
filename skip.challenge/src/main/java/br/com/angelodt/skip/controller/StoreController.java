package br.com.angelodt.skip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.angelodt.skip.api.dto.ProductDTO;
import br.com.angelodt.skip.api.dto.StoreDTO;
import br.com.angelodt.skip.service.StoreService;

@RestController
@RequestMapping("/api/v1/Store")
public class StoreController {

    @Autowired
    private StoreService storeService;
    
    @GetMapping
    public List<StoreDTO> getAll() {
        return storeService.getAll();
    }
    
    @GetMapping("/search/{searchText}")
    public List<StoreDTO> search(@PathVariable String searchText) {
        return storeService.search(searchText);
    }
    
    @GetMapping("/{storeId}")
    public StoreDTO getStore(@PathVariable Long storeId) {
        return storeService.getStore(storeId);
    }
    
    @GetMapping("/{storeId}/products")
    public List<ProductDTO> getProducts(@PathVariable Long storeId) {
        return storeService.getProducts(storeId);
    }
}
