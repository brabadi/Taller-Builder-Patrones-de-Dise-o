
package co.unicauca.restaurant.services;

import co.unicauca.restaurant.domain.Dish;

public class DishDirector {

    private final DishBuilder builder;

    public DishDirector(DishBuilder builder) {
        this.builder = builder;
    }

    public Dish getDish() {
        return builder.getDish();
    }

    public void create(String nombre,String imagen) {
        boolean masPartes = true;
        builder.init(nombre,imagen);
        builder.setCore();
        while (masPartes) {
            masPartes = builder.addPart();
        }
        builder.setSize();
    }
}
