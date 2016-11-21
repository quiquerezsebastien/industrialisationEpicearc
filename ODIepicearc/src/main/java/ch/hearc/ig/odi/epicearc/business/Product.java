package ch.hearc.ig.odi.epicearc.business;

/**
 *
 * @author julien.plumez
 */
public class Product {

    private Long id;
    private Float price;
    private ConiferType coniferType;
    private ConiferSize coniferSize;
    
    public Product(){
        
    }

    public Product(Long id, Float price, ConiferType coniferType, ConiferSize coniferSize) {
        this.id = id;
        this.price = price;
        this.coniferType = coniferType;
        this.coniferSize = coniferSize;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public ConiferType getConiferType() {
        return coniferType;
    }

    public void setConiferType(ConiferType coniferType) {
        this.coniferType = coniferType;
    }

    public ConiferSize getConiferSize() {
        return coniferSize;
    }

    public void setConiferSize(ConiferSize coniferSize) {
        this.coniferSize = coniferSize;
    }
    
    
    
}
