
package co.unicauca.restaurant.services;

import co.unicauca.restaurant.access.IProductRepository;
import co.unicauca.restaurant.domain.Dish;
import co.unicauca.restaurant.domain.Product;
import java.util.List;

public abstract class DishBuilder {
    protected Dish myDish;
    protected IProductRepository myRepository;
    protected List<Product> allProducts;
    protected List<Product> bases;
    protected List<Product> options;

    public IProductRepository getMyRepository() {
        return myRepository;
    }

    public void setMyRepository(IProductRepository myRepository) {
        this.myRepository = myRepository;
    }

    public List<Product> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<Product> allProducts) {
        this.allProducts = allProducts;
    }

    public List<Product> getBases() {
        return bases;
    }

    public void setBases(List<Product> bases) {
        this.bases = bases;
    }

    public List<Product> getOptions() {
        return options;
    }

    public void setOptions(List<Product> options) {
        this.options = options;
    }
    
    public Dish getDish() {
        return myDish;
    }
    
    public void setDish(Dish myDish) {
        this.myDish = myDish;
    }

    public abstract DishBuilder init(String nombre,String imagen);

    public abstract DishBuilder setCore();

    public abstract boolean addPart();

    public abstract DishBuilder setSize();
}
