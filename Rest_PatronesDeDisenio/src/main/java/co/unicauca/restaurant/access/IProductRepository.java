
package co.unicauca.restaurant.access;

import co.unicauca.restaurant.domain.Product;
import java.util.List;

/**
 *  Interface de los servicios del repositorio
 */
public interface IProductRepository {
    List<Product> findAll();
    Product findById(Integer id);
    boolean create(Product newProduct);
    boolean update(Product newProduct);
    boolean delete(Integer id);
}
