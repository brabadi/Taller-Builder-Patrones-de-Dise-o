
package co.unicauca.restaurant.access;

import co.unicauca.restaurant.domain.Product;
import java.util.ArrayList;
import java.util.List;

public class ItalianRepositoryImplArrays implements IProductRepository{
    public static List<Product> products;
    
    public ItalianRepositoryImplArrays(){
        products = new ArrayList<>();
        initialize();
    }
    /**
    *  Inicializacion donde se agregan 6 productos de Comida Italiana
    */
    private void initialize() {
        products.add(new Product(1, "Lasaña de Pollo", 20000d));
        products.add(new Product(2, "Sopa Minestrone", 9000d));
        products.add(new Product(3, "Ossobuco", 18000d));
        products.add(new Product(4, "Grissinis", 6000d));
        products.add(new Product(5, "Spaguetti a la Carbonara", 20000d));
        products.add(new Product(6, "Ensalada Cesar", 15000d));
    }
    
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Integer id) {
        for(Product prod:products){
            if (prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }

    @Override
    public boolean create(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
                //Ya existe
                return false;
        }
        products.add(newProduct);
        return true;
    }

    @Override
    public boolean update(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
            prod.setName(newProduct.getName());
            prod.setPrice(newProduct.getPrice());
        return true;
        }
    return false;
    }

    @Override
    public boolean delete(Integer id) {
        for (Product prod : products) {
                if (prod.getId() == id) {
                    products.remove(prod);
                    return true;
                }
        }
        return false;
    }
}
