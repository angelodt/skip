package br.com.angelodt.skip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.angelodt.skip.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
    
    @Query("SELECT s FROM Store s WHERE upper(s.name) LIKE UPPER(CONCAT('%',:searchText,'%')) ")    
    public List<Store> searchByName(@Param("searchText") String searchText);
    
    public List<Store> findByCousineId(Long cousineId);
    
}
