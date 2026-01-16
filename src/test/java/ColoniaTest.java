import unam.diplomado.mixup.registrarusuario.colonia.domain.Colonia;
import unam.diplomado.mixup.registrarusuario.colonia.repository.ColoniaRepository;
import unam.diplomado.mixup.registrarusuario.colonia.repository.JpaColoniaRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ColoniaTest {

    public static void main(String[] args) {
        String cp= "45454";
        ColoniaRepository coloniaRepository=new JpaColoniaRepository();
        Collection<Colonia> colonias=coloniaRepository.findByCp(cp);

        for (Colonia c : colonias){
            System.out.println(

                   "Nombre: " + c.getNombre()
            );
        }
    }
}
