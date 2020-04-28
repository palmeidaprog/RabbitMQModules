package com.projetosd.coronawebservice.agendamento;

import com.projetosd.entities.Agendamento;
import com.projetosd.entities.EntitiesConverter;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@PermitAll
@Path("/agendamento")
public class AgendamentoService {

    private final static Logger LOGGER = LoggerFactory.getLogger(
            AgendamentoService.class.getName());

    private final AgendamentoServiceHandler serviceHandler =
            new AgendamentoServiceHandler();

    @POST
    @Path("create")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response create(String jsonString) {
        LOGGER.info("create :: Recebendo requisicao HTTP em /agendamento/create ...");
        final Agendamento agendamento = EntitiesConverter.parseAgendamento(
                new JSONObject(jsonString));

        try {
            this.serviceHandler.create(agendamento);
            LOGGER.info("create :: Agendamento id {} criado com sucesso!", agendamento.getId());
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.error("create :: Erro ao criar o Agendamento id {}. Erro: {}", agendamento.getId(), e.getMessage(), e);
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

}

/*
*  regra de negocio no serviceHandler --> controller
*  service --> recebimento resposta e http --> ok=200 , erro=500
*
*
* */