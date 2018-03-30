package br.com.angelodt.skip.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "store")
public class Store implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(targetEntity = Cousine.class, fetch = FetchType.LAZY)
    @JoinColumn(name="cousine_id", referencedColumnName="id", insertable =  false, updatable = false)
    private Cousine cousine;
    
    @OneToMany(mappedBy = "store", targetEntity = Product.class, fetch = FetchType.LAZY)
    private List<Product> product;
    
    private String name;
    
    private String description;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Cousine getCousine() {
        return cousine;
    }
    public void setCousine(Cousine cousine) {
        this.cousine = cousine;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Product> getProduct() {
        return product;
    }
    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
