package unam.diplomado.mixup.creardisco.disco.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.Response;
import unam.diplomado.mixup.creardisco.disco.domain.Disco;
import unam.diplomado.mixup.creardisco.disco.service.DiscoService;

@RequestScoped
public class DiscoResource implements DiscoApi{

   private DiscoService discoService;

    @Override
    public Response altaDisco(Disco disco) {





        return null;
    }
}
