package com.projetosd.produceconsume;

import com.projetosd.entities.Agendamento;
import com.projetosd.entities.Atendimento;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgendamentoConsumidor extends Consumidor {

    private final static Logger LOGGER = LoggerFactory.getLogger(
            AgendamentoConsumidor.class.getName());

    private FuncaoProdutor<Agendamento> callback;

    public AgendamentoConsumidor() {
        super("agendamento", "agendamento");
    }

    public void run(FuncaoProdutor<Agendamento> funcaoCallback) {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("138.197.71.50");
        factory.setUsername("paulo");
        factory.setPassword("paulo");
        factory.setAutomaticRecoveryEnabled(true);

        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            LOGGER.info("No construtor :: Produtor de Agendamento " +
                    "inicializado com sucesso!");

            channel.exchangeDeclare(getExchangeName(), "direct");
            channel.queueDeclare(getFila(), true, false, false, null);
            channel.queueBind(getFila(), getExchangeName(), getConsumerTag());

            LOGGER.info("run :: Thread em modo de escuta da fila {} ...",
                    getFila());

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                final String jsonString = new String(delivery.getBody(),
                        "UTF-8");

                final JSONObject json = new JSONObject(jsonString);
                LOGGER.info("run :: Agendamento como JSON recebido: {}",
                        json.toString(4));
                funcaoCallback.funcaoASerChamada(this.parseAgendamento(json));
            };
            channel.basicConsume(getFila(), true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            LOGGER.error("run :: Erro na conexão do consumidor do " +
                    "Agendamento Erro: {}", e.getMessage(), e);
        }
    }
}
