package unam.diplomado.mixup.creardisco.disco.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.mixup.creardisco.disco.api.dto.*;
import unam.diplomado.mixup.creardisco.disco.domain.Disco;
import unam.diplomado.mixup.creardisco.disco.service.DiscoService;
import unam.diplomado.mixup.registrarusuario.usuario.api.dto.RegistroUsuarioMapper;
import unam.diplomado.mixup.registrarusuario.usuario.api.dto.UsuarioResponseDTO;

@RequestScoped
public class DiscoResource implements DiscoApi{

    @Inject
   private DiscoService discoService;
    @Inject
    private RegistroDiscoMapper mapper;

    @Override
    public Response altaDisco(DiscoRequestDTO registroDiscoDTO) {

        Disco discoRequest=mapper.toDisco(registroDiscoDTO);

     Disco discoGuardado=discoService.registrarDisco(discoRequest);

       DiscoResponseDTO discoResponseDTO = mapper.toDto(discoGuardado);
        return Response
                .status(Response.Status.CREATED)
                .entity(discoResponseDTO)
                .build();

    }
}
