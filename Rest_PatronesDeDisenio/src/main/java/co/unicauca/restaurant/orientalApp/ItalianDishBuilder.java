
package co.unicauca.restaurant.orientalApp;

import co.unicauca.restaurant.access.ItalianRepositoryImplArrays;
import co.unicauca.restaurant.domain.Product;
import co.unicauca.restaurant.domain.Size;
import co.unicauca.restaurant.services.DishBuilder;
import co.unicauca.restaurant.utilities.Consola;
import java.util.ArrayList;
import java.util.List;

public class ItalianDishBuilder extends DishBuilder{
    private ItalianDish myItalianDish;
    /**
     * Lee de forma dinamica los productos a partir de una lista
     * 
     * @param myProducts
     * @param foodPart
     * @return 
     */
    private Product read(List<Product> myProducts, String foodPart) {
        int input=0;
        while (input<1 || input>myProducts.size()){
            int i = 1;
            Consola.escribirSaltarLinea("Seleccione una " + foodPart, false);
            for (Product each : myProducts) {
                Consola.escribirSaltarLinea("" + i + ". " + each.getName() + ":" + each.getPrice(), false);
                i++;
            }
            input=Consola.leer("Ingrese el código de la "+foodPart +":",input, false);
        }
        return myProducts.get(input - 1);
    }
    /**
     * Inicia la creacion del plato Italiano
     * 
     * @param nombre
     * @param imagen
     * @return 
     */
    @Override
    public DishBuilder init(String nombre,String imagen) {
        myRepository = new ItalianRepositoryImplArrays();
        myDish = new ItalianDish(nombre,imagen,0.0);
        myItalianDish = (ItalianDish) myDish;
        //Obtenemos todos los productos
        allProducts = myRepository.findAll();
        // Obtenemos las bases y las opciones
        bases = new ArrayList<>();
        options = new ArrayList<>();
        for (Product each : allProducts) {
            if (each.getId() <4) {
                bases.add(each);
            } else if (each.getId() >3) {
                options.add(each);
            }
        }
        return this;
    }
    /**
     * Añade la base del plato Italiano
     * 
     * @return 
     */
    @Override
    public DishBuilder setCore() {
        myItalianDish.setBase(read(bases, "Base"));
        return this;
    }
    
    /**
     * Añade los acompañantes del plato Italiano
     * 
     * @return 
     */
    @Override
    public boolean addPart() {
        String opcion=" ";
        myItalianDish.addOption(read(options, "Opcion"));
        opcion=Consola.leer("Digite S para obtener más opciones de lo contrario presione cualquier "
                + "tecla para Continuar",opcion,false);
        return opcion.matches("[Ss]");
    }
    
    /**
     * elige el tamaño del plato Italiano
     * 
     * @return 
     */
    @Override
    public DishBuilder setSize() {
        String tamano = " ";
        do {
            tamano = Consola.leer("Digite la letra correspondiente para el tamaño "
                    + "Personal(P), Doble (D), Familiar (F)", tamano, false);
        } while (!Consola.es_P_D_F(tamano));
        if (tamano.equals("F")) {
            myItalianDish.setSize(Size.FAMILIAR);
        }
        if (tamano.equals("D")) {
            myItalianDish.setSize(Size.DOBLE);
        }
        if (tamano.equals("P")) {
            myItalianDish.setSize(Size.PERSONAL);
        }
        return this;
    }
    
}
