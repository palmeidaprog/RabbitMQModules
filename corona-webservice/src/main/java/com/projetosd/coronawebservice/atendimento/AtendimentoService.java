package com.projetosd.coronawebservice.atendimento;


import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@PermitAll
@Path("/atendimento")
public class AtendimentoService {

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create() {

    }
}
