package unam.diplomado.mixup.creardisco.disco.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.mixup.creardisco.disco.domain.*;
import unam.diplomado.mixup.creardisco.disco.repository.ArtistaRepository;
import unam.diplomado.mixup.creardisco.disco.repository.DiscoRepository;
import unam.diplomado.mixup.creardisco.disco.repository.DisqueraRepository;
import unam.diplomado.mixup.creardisco.disco.repository.GeneroMusicalRepository;

import java.util.Optional;

@Stateless
public class DiscoServiceImpl implements DiscoService{
    @Inject
    private DisqueraRepository disqueraRepository;
    @Inject
    private ArtistaRepository artistaRepository;
    @Inject
    private GeneroMusicalRepository generoMusicalRepository;
    @Inject
    private DiscoRepository discoRepository;

    @Override
    public Disco registrarDisco(Disco disco) {
        //Validacion que exista la disquera a la cual se asocia el disco
        Optional<Disquera> disqueraExistente=disqueraRepository.findById(disco.getDisquera().getId());

       if(disqueraExistente.isEmpty()){
          throw new RecordLabelNotFoundException(disco.getDisquera().getId());
       }
       //asignar la disquera de la base de datos para mantener la consistencia en los datos
       disco.setDisquera(disqueraExistente.get());

        //Validar la existencia del artista al cuañl se asocia el disco
        Optional<Artista> artistaExistente=artistaRepository.findById(disco.getArtista().getId());
       if(artistaExistente.isEmpty()){
          throw new ArtistNotFoundException(disco.getArtista().getId());
       }
        //asignar el artista de la base de datos para mantener la consistencia en los datos
       disco.setArtista(artistaExistente.get());
       //que exista el genero musical al cual se asocia el disco
       // MusicGenderNotFounException

        Optional<GeneroMusical> generoMusicalExistente=generoMusicalRepository.findById(disco.getGeneroMusical().getId());
       if(generoMusicalExistente.isEmpty()){
           throw new MusicGenreNotFoundException(disco.getGeneroMusical().getId());
       }
        //asignar el genero musical de la base de datos para mantener la consistencia en los datos
       disco.setGeneroMusical(generoMusicalExistente.get());
        //Validar que no existapreviamente el disco que se desea registrar(validar duplicidad)
        //Para validar si ya existe un discorealizar la busqueda por medio de la tupla (titulo, idArtista)
      //DiscAlreadyExistException
        Optional<Disco> discoExistente=discoRepository.findByTituloAndArtista(disco.getTitulo(),disco.getArtista().getId());
       if(discoExistente.isPresent()){
           throw new DiscAlreadyExistsException(disco.getTitulo(),disco.getArtista().getId());
       }

       //persistir el disco
        discoRepository.save(disco);

       return disco;

}
}
