package br.com.angelodt.skip.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.angelodt.skip.api.dto.ProductDTO;
import br.com.angelodt.skip.converter.ProductConverter;
import br.com.angelodt.skip.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductConverter converter;

    @Autowired
    private ProductRepository productRepository;
    
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream()
                .map(p -> converter.convertForm(p))
                .collect(Collectors.toList());
    }

    public List<ProductDTO> search(String searchText) {
        return productRepository.findByNameContains(searchText).stream()
                .map(p -> converter.convertForm(p))
                .collect(Collectors.toList());
    }

    public ProductDTO getProduct(Long productId) {
        return converter.convertForm(productRepository.getOne(productId));
    }
   
    public List<ProductDTO> findByStore(Long storeId) {
        return productRepository.findByStoreId(storeId).stream()
                .map(p -> converter.convertForm(p))
                .collect(Collectors.toList());
    }

}
