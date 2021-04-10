
package co.unicauca.restaurant.orientalApp;

import co.unicauca.restaurant.domain.Dish;
import co.unicauca.restaurant.domain.Product;
import co.unicauca.restaurant.domain.Size;
import java.util.ArrayList;

/**
 *  Especializacion a un plato Oriental
 */
public class OrientalDish extends Dish{

    public OrientalDish(String nombre,String imagen,double precio) {
        this.nombre=nombre;
        this.imagen=imagen;
        this.price = precio;
        this.myOptions = new ArrayList<>();
    }
    
    /**
     * Añade opciones al plato Oriental
     * 
     * @param option 
     */
    public void addOption(Product option) {
        this.getMyOptions().add(option);
    }
    /**
     * Calcula el precio del plato Oriental
     * 
     * @return 
     */
    @Override
    public double getPrice(){
        this.price = this.base.getPrice();
        for(Product each: myOptions){
            price = price + each.getPrice();
        }
        if(size==Size.DOBLE) price = 1.8*price;
        if(size==Size.FAMILIAR) price = 3*price;
        return price;
    }
}
