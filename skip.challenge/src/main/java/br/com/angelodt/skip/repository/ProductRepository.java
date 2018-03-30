package br.com.angelodt.skip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.angelodt.skip.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByName(String searchText);
    
    public List<Product> findByNameContains(String searchText);
    
    public  List<Product> findByStoreId(Long storeId);
    
}
