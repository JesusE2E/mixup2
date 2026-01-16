package unam.diplomado.mixup.registrarusuario.colonia.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.mixup.registrarusuario.colonia.domain.*;
import unam.diplomado.mixup.registrarusuario.colonia.repository.ColoniaRepository;
import unam.diplomado.mixup.registrarusuario.colonia.repository.MunicipioRepository;

import java.util.Optional;
//el contenedor se encarga del ciclo de vida del bean
@Stateless
public class ColoniaServiceImpl implements ColoniaService{

    @Inject//inyecta referencias del repository
    private ColoniaRepository coloniaRepository;

    @Inject
    private MunicipioRepository municipioRepository;

    @Override
    public Colonia obtenerColoniaPorId(Integer id) throws ColoniaNotFoundException {
        Optional<Colonia> colonia = coloniaRepository.findById(id);
        if (colonia.isPresent()) {
            return colonia.get();
        }
        throw new ColoniaNotFoundException(id);


    }

    @Override
    public Colonia crearColonia(Colonia colonia) {

        Optional<Colonia>coloniaExistente=
                coloniaRepository.findByCpAndNombre(colonia.getCodigoPostal(),colonia.getNombre());
        if(coloniaExistente.isPresent()){
            throw new ColoniaAlreadyExistsException(colonia.getCodigoPostal(),colonia.getNombre());
        }
        Optional<Municipio> municipioExistente=
                municipioRepository.findById(colonia.getMunicipio().getId());
        if(municipioExistente.isEmpty()){
            throw new MunicipioNotFoundException(colonia.getMunicipio().getId());
         }
        colonia.setMunicipio(municipioExistente.get());
        coloniaRepository.saveOrUpdate(colonia);
        return colonia;

        /*Optional<Colonia> coloniaExistente=coloniaRepository
              .findByCpAndNombre(colonia.getCodigoPostal(),colonia.getNombre());

      if(coloniaExistente.isPresent()){
throw new ColoniaAlreadyExistsException(colonia.getCodigoPostal(),colonia.getNombre());
      }


      Optional <Municipio>municipioExistente=
              municipioRepository.findById(colonia.getMunicipio().getId());
      if(municipioExistente.isEmpty()){
          throw  new MunicipioNotFoundException(colonia.getMunicipio().getId());
      }
      colonia.setMunicipio(municipioExistente.get());
      coloniaRepository.saveOrUpdate(colonia);
        return colonia;*/
    }

    @Override
    public Colonia actualizarColonia(Colonia colonia) {
        Optional<Colonia> coloniaExistente=coloniaRepository.findById(colonia.getId());
        if(coloniaExistente.isEmpty()){
         throw  new ColoniaNotFoundException(colonia.getId());
        }
        Optional<Colonia> coloniaExistente2=coloniaRepository.findByCpAndNombre(colonia.getCodigoPostal(),colonia.getNombre());
        if(coloniaExistente2.isEmpty()){
            throw  new ColoniaAlreadyExistsException(colonia.getCodigoPostal(),colonia.getNombre());
        }
        Optional<Municipio>municipioExistente=municipioRepository.findById(colonia.getMunicipio().getId());
        if(municipioExistente.isEmpty()){
            throw  new MunicipioNotFoundException(colonia.getMunicipio().getId());
        }
        Colonia coloniaActualizar=coloniaExistente.get();
        coloniaActualizar.setMunicipio(municipioExistente.get());
        coloniaActualizar.setNombre(colonia.getNombre());
        coloniaActualizar.setCodigoPostal(colonia.getCodigoPostal());
        coloniaRepository.saveOrUpdate(coloniaActualizar);
        return coloniaActualizar;
    }

    @Override
    public void eliminarColoniaPorId(Integer id) {
Optional<Colonia> colonias=coloniaRepository.findById(id);

if(colonias.isPresent()){
    coloniaRepository.delete(colonias.get());
     }
/*
        coloniaRepository.findById(colonias.get().getId())
                .ifPresent(colonia1 -> coloniaRepository.delete(colonias.get()));

         */}
}



