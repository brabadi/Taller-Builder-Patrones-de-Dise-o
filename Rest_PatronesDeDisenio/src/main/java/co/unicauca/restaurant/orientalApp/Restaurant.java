
package co.unicauca.restaurant.orientalApp;

import co.unicauca.restaurant.domain.Dish;
import co.unicauca.restaurant.domain.Menu;
import co.unicauca.restaurant.services.DishDirector;
import co.unicauca.restaurant.utilities.Consola;

public class Restaurant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ruta="";
        DishDirector directorOriental = new DishDirector(new OrientalDishBuilder());
        DishDirector directorItalian =new DishDirector(new ItalianDishBuilder());
        
        directorOriental.create("Plato Oriental",ruta);
        Dish myDish = directorOriental.getDish();
        
        Menu menOriental=new Menu("Oriental");
        menOriental.setPlatos(myDish);
        Consola.escribirSaltarLinea("Menu "+menOriental.getNombre(), false);
        for (Dish plato : menOriental.getPlatos()) {
            Consola.escribirSaltarLinea("plato: "+plato.getNombre(), false);
            Consola.escribirSaltarLinea("Precio: "+plato.getPrice(), false);
        }
        directorItalian.create("Plato Italiano",ruta);
        Dish myDishIta=directorItalian.getDish();

        Menu menItaliano=new Menu("Italiano");
        menItaliano.setPlatos(myDishIta);
        Consola.escribirSaltarLinea("Menu "+menItaliano.getNombre(), false);
        for (Dish plato : menItaliano.getPlatos()) {
            Consola.escribirSaltarLinea("plato: "+plato.getNombre(), false);
            Consola.escribirSaltarLinea("Precio: "+plato.getPrice(), false);
        }     
    }   
}
