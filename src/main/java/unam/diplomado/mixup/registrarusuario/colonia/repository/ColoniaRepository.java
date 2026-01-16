package unam.diplomado.mixup.registrarusuario.colonia.repository;

import unam.diplomado.mixup.registrarusuario.colonia.domain.Colonia;

import java.util.List;
import java.util.Optional;

public interface ColoniaRepository {

   List<Colonia> findByCp(String cp);
   Optional<Colonia> findById(Integer id);
   Optional<Colonia> findByCpAndNombre(String cp,String nombre);
   Colonia saveOrUpdate(Colonia colonia);
   //nocambiar es Colonia colonia
   void delete(Colonia colonia);
}
