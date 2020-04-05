package com.projetosd.coronawebservice.agendamento;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@PermitAll
@Path("/api")
public class AgendamentoService {

    @POST
    @Path("exemplo")
    public void exemplo() {

    }
}
