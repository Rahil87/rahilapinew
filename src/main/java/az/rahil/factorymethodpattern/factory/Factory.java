package az.rahil.factorymethodpattern.factory;

import az.rahil.factorymethodpattern.product.Model;


//Bu interface in iwi Modelin datalarini qaytaran metod generasiya etmekdir
//Amma hansi classin datalarini qaytardigi melum deyil
public interface Factory {

    Model getData();
}
