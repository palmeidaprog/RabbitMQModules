package com.projetosd.coronawebservice.atendimento;


import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import com.projetosd.entities.Agendamento;
import com.projetosd.entities.Atendimento;
import com.projetosd.entities.EntitiesConverter;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PermitAll
@Path("/atendimento")
public class AtendimentoService {

    private final static Logger LOGGER = LoggerFactory.getLogger(
            AtendimentoService.class.getName());

    private final AtendimentoServiceHandler serviceHandler = new AtendimentoServiceHandler();

    @POST
    @Path("create")
    @Consumes({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public Response create(String jsonString) {
        LOGGER.info("create :: Recebendo requisicao HTTP em atendimento/create...");
        final Atendimento atendimento = EntitiesConverter.parseAtendimento(
                new JSONObject(jsonString));

        try {
            this.serviceHandler.create(atendimento);
            LOGGER.info("create  :: Atendimento id {} criado com sucesso!", atendimento.getId());
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.error("create :: Erro ao criar o Atendimento id {}. Erro: {}",atendimento.getId(),e.getMessage(),e);
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }

    }
}
