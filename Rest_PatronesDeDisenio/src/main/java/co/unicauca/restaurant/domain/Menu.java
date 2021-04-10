
package co.unicauca.restaurant.domain;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String nombre;
    private final List<Dish> platos;

    public Menu(String nombre) {
        this.nombre = nombre;
        this.platos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Dish> getPlatos() {
        return platos;
    }

    public void setPlatos(Dish plato) {
        this.platos.add(plato);
    }
    
    
}
