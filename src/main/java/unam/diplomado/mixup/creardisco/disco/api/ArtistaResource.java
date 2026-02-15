package unam.diplomado.mixup.creardisco.disco.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.mixup.creardisco.disco.domain.Artista;
import unam.diplomado.mixup.creardisco.disco.domain.Disquera;
import unam.diplomado.mixup.creardisco.disco.service.ArtistaService;
import unam.diplomado.mixup.creardisco.disco.service.DisqueraService;

import java.util.List;

@RequestScoped
public class ArtistaResource implements ArtistaApi{

    @Inject
    private ArtistaService artistaService;

    @Override
    public Response obtenerArtistas() {
        List<Artista> artistas=artistaService.obtenerTodos();
        return  Response
                .status(Response.Status.OK)
                .entity(artistas)
                .build();
    }
}

