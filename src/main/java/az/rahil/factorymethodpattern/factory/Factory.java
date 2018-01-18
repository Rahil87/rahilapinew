package az.rahil.factorymethodpattern.factory;

import az.rahil.factorymethodpattern.product.Model;

import java.util.List;


//Bu interface in iwi Modelin datalarini qaytaran metod generasiya etmekdir
//Amma hansi classin datalarini qaytardigi melum deyil
public interface Factory {

     List<? extends Model>getListData();
}
