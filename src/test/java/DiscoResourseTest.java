import unam.diplomado.mixup.creardisco.disco.api.DiscoResource;
import unam.diplomado.mixup.creardisco.disco.domain.Artista;
import unam.diplomado.mixup.creardisco.disco.domain.Disco;
import unam.diplomado.mixup.creardisco.disco.domain.Disquera;
import unam.diplomado.mixup.creardisco.disco.domain.GeneroMusical;
import unam.diplomado.mixup.creardisco.disco.service.DiscoService;

import java.util.Date;

public class DiscoResourseTest {

    public static void main(String[] args) {
        DiscoResource discoResource=new DiscoResource();


        Disco disco =new Disco(null,"nirvana",22.1,20,0.0,
                new Date(2000,10,10),"imagen",
                new Artista(1,"Metalica"),new Disquera(3,"BMG"),
                new GeneroMusical(2,"Pop"));

      //  discoResource.altaDisco(disco);
    }
}
