
package co.unicauca.restaurant.orientalApp;

import co.unicauca.restaurant.domain.Dish;
import co.unicauca.restaurant.domain.Product;
import co.unicauca.restaurant.domain.Size;
import java.util.ArrayList;

/**
 *  Especializacion a un plato Italiano
 */
public class ItalianDish extends Dish{

    public ItalianDish(String nombre,String imagen,double precio) {
        this.nombre=nombre;
        this.imagen=imagen;
        this.price = precio;
        this.myOptions = new ArrayList<>();
    }

    /**
     * Añade opciones al plato Italiano
     * 
     * @param option 
     */
    public void addOption(Product option) {
        this.getMyOptions().add(option);
    }
    /**
     * Calcula el precio del plato Italiano
     * @return 
     */
    @Override
    public double getPrice(){
        this.price = this.base.getPrice();
        for(Product each: myOptions){
            price = price + each.getPrice();
        }
        if(size==Size.DOBLE) price = 2*price;
        if(size==Size.FAMILIAR) price = 3.2*price;
        return price;
    }
}