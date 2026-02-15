package unam.diplomado.mixup.creardisco.disco.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.mixup.creardisco.disco.domain.Disquera;
import unam.diplomado.mixup.creardisco.disco.service.DisqueraService;

import java.util.List;

@RequestScoped
public class DisqueraResource implements DisqueraApi{

    @Inject
    private DisqueraService disqueraService;


    @Override
    public Response obtenerDisqueras() {

        List<Disquera> disqueras=disqueraService.obtenerDisqueras();

        return  Response
                .status(Response.Status.OK)
                .entity(disqueras)
                .build();
    }
}

