
package co.unicauca.restaurant.domain;

import java.util.List;
/**
    * Creacion de la Clase Dish 
    */
public class Dish {
    protected String nombre;
    protected double price;
    protected String imagen;
    protected Product base;
    protected List<Product> myOptions;
    protected Size size;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String Imagen) {
        this.imagen = Imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getBase() {
        return base;
    }

    public void setBase(Product base) {
        this.base = base;
    }

    public List<Product> getMyOptions() {
        return myOptions;
    }

    public void setMyOptions(List<Product> myOptions) {
        this.myOptions = myOptions;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
    
}
