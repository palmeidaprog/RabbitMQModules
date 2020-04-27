package com.projetosd.coronawebservice.util;

import com.projetosd.coronawebservice.agendamento.AgendamentoServiceHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class IdGenerator {

    private static Logger LOGGER = LoggerFactory.getLogger(
            IdGenerator.class.getName());

    private static Integer lastId = 0;

    public static synchronized Integer generateId() {
        LOGGER.debug("generateId :: Gerando Id ...");
        LocalDateTime now = LocalDateTime.now();
        final int minute = now.getMinute();
        int second = now.getSecond();

        if (++lastId == 1000) {
            lastId = 0;
        }

        final String idStr = String.format("%02d%02d%03d", minute, second, lastId);
        Integer id = Integer.valueOf(idStr);
        LOGGER.info("generateId :: Id {} gerada com sucesso!", id);

        return id;
    }
}
