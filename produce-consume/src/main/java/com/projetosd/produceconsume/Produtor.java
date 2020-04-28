package com.projetosd.produceconsume;

import com.projetosd.entities.Agendamento;
import com.projetosd.entities.Atendimento;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Produtor {
    private final static Logger LOGGER = LoggerFactory.getLogger(Produtor
            .class.getName());

    private static final String EXCHANGE_NAME = "corona";

    private final ConnectionFactory factory;

    public Produtor() {
        this.factory = new ConnectionFactory();
        this.factory.setHost("138.197.71.50");
        this.factory.setUsername("paulo");
        this.factory.setPassword("paulo");
    }

    /**
     * Publica o Agendamento na filha "agendamento"
     * @param agendamento Agendamento a ser publicado
     */
    public void publish(Agendamento agendamento) {
        LOGGER.info("publish :: Publicando Agendamento id {} na fila de " +
                "atendimento ... ", agendamento.getId());
        this.publish(agendamento, "agendamento",
                "Agendamento");
    }

    /**
     * Publica o Atendimento na filha "atendimento"
     * @param atendimento Atendimento a ser publicado
     */
    public void publish(Atendimento atendimento) {
        LOGGER.info("publish :: Publicando Atendimento id {} na fila de " +
                "atendimento ... ", atendimento.getId());
        this.publish(atendimento, "atendimento",
                "Atendimento");
    }

    /**
     * Publica qualquer objeto na fila especificada
     * @param object Objeto a ser publicado
     * @param queue nome da fila
     * @param objectName Nome do objeto
     * @param <T> Tipo do objeto
     */
    private  <T> void publish(T object, String queue, String objectName) {
        List<String> queues = new ArrayList<>();
        queues.add(queue + "_banco");
        queues.add(queue + "_atendente");
        queues.add(queue + "_emissor");
        final JSONObject json = new JSONObject(object);

        try (Connection connection = this.factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            for (String q : queues) {
                channel.queueDeclare(q, true, false, false, null);
                channel.basicPublish(EXCHANGE_NAME, q, null,
                        json.toString().getBytes());
            }

            // se o nome do objeto nao for informado
            if (objectName == null) {
                StringBuilder sb = new StringBuilder(queue);
                sb.setCharAt(0, Character.toUpperCase(queue.charAt(0)));
                objectName = sb.toString();
            }

            LOGGER.info("publish :: {} publicado na fila de {} com sucesso." +
                    " Objeto: {}", objectName, queue,
                    json.toString(4));
        } catch (Exception e) {
            LOGGER.error("publish :: Erro ao publicar {} Obejto: {} Erro: " +
                "{}", objectName, json.toString(4),
                    e.getMessage(), e);
        }
    }


}
