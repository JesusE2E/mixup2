package unam.diplomado.mixup.creardisco.disco.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.mixup.creardisco.disco.domain.Disquera;
import unam.diplomado.mixup.creardisco.disco.domain.GeneroMusical;
import unam.diplomado.mixup.creardisco.disco.service.DisqueraService;
import unam.diplomado.mixup.creardisco.disco.service.GeneroMusicalService;

import java.util.List;

@RequestScoped
public class GeneroMusicalResource implements GeneroMusicalApi{

    @Inject
    private GeneroMusicalService generoMusicalService;



    @Override
    public Response obtenerGenerosMusicales() {
        List<GeneroMusical> generos=generoMusicalService.obtenerTodos();

        return  Response
                .status(Response.Status.OK)
                .entity(generos)
                .build();
    }
}

