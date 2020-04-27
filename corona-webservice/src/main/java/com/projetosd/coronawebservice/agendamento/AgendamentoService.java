package com.projetosd.coronawebservice.agendamento;


import javax.annotation.security.PermitAll;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@PermitAll
@Path("/atendimento")
public class AgendamentoService {

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create() {



    }
}
