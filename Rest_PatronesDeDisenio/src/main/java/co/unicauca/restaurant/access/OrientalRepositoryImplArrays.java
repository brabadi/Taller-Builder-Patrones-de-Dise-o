
package co.unicauca.restaurant.access;

import co.unicauca.restaurant.domain.Product;
import java.util.ArrayList;
import java.util.List;

public class OrientalRepositoryImplArrays implements IProductRepository{
    public static List<Product> products;
    
    public OrientalRepositoryImplArrays(){
        products = new ArrayList<>();
        initialize();
    }
    /**
    *  Inicializacion donde se agregan 6 productos de Comida Oriental
    */
    private void initialize() {
        
        products.add(new Product(1, "Ramen", 30000d));
        products.add(new Product(2, "Rollos Primavera", 25000d));
        products.add(new Product(3, "Jiaozi", 5000d));
        products.add(new Product(4, "Huo Guo o Hot Pot", 30000d));
        products.add(new Product(5, "Wan Tan Mee", 8000d));
        products.add(new Product(6, "Arroz al estilo Oriental", 10000d));
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
