package com.projetosd.emissormail;

import com.projetosd.produceconsume.Fila;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.projetosd.emissormail.email.controller.EmailController;
import com.projetosd.produceconsume.AtendimentoConsumidor;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.info("main(): Programa de emissao de e-mail inicializado");
       
        final EmailController emailController = new EmailController();
    	emailController.authentication();

        final AtendimentoConsumidor consumidor = new AtendimentoConsumidor(Fila.EMISSOR);
        consumidor.run(atendiment -> {emailController.emailProcessor(atendiment);});

    }
}
