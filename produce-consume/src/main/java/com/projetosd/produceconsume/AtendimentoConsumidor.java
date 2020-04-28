package com.projetosd.produceconsume;

import com.projetosd.entities.Atendimento;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class AtendimentoConsumidor extends Consumidor {

    private final static Logger LOGGER = LoggerFactory.getLogger(
            AtendimentoConsumidor.class.getName());

    private FuncaoProdutor<Atendimento> callback;

    private Fila fila;

    public AtendimentoConsumidor(Fila fila) {
        super("atendimento", "atendimento");
        this.fila = fila;
    }


    public void run(FuncaoProdutor<Atendimento> funcaoCallback) {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("138.197.71.50");
        factory.setUsername("paulo");
        factory.setPassword("paulo");
        factory.setAutomaticRecoveryEnabled(true);

        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            LOGGER.info("No construtor :: Produtor de Atendimento " +
                    "inicializado com sucesso!");

            channel.exchangeDeclare(getExchangeName(), "direct");
            channel.queueDeclare(getFila()+this.fila.getValor(), true, false, false, null);
            channel.queueBind(getFila()+this.fila.getValor(), getExchangeName(), getConsumerTag()+this.fila.getValor());


            LOGGER.info("run :: Thread em modo de escuta da fila {} ...",
                    getFila()+this.fila.getValor());

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                final String jsonString = new String(delivery.getBody(),
                        "UTF-8");

                final JSONObject json = new JSONObject(jsonString);
                LOGGER.info("run :: Atendimento como JSON recebido: {}",
                        json.toString(4));
                funcaoCallback.funcaoASerChamada(this.parseAtendimento(json));
            };
            channel.basicConsume(getFila()+this.fila.getValor(), true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            LOGGER.error("run :: Erro na conexão do consumidor do " +
                    "Atendimento Erro: {}", e.getMessage(), e);
        }
    }

}
