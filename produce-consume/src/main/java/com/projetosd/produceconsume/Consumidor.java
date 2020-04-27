package com.projetosd.produceconsume;

import com.projetosd.entities.Agendamento;
import com.projetosd.entities.Atendente;
import com.projetosd.entities.Atendimento;
import com.projetosd.entities.Endereco;
import com.projetosd.entities.Paciente;
import com.projetosd.entities.Pessoa;
import com.projetosd.entities.PessoaSexo;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public abstract class Consumidor {

    private final static Logger LOGGER = LoggerFactory.getLogger(
            Consumidor.class.getName());

    private static final String EXCHANGE_NAME = "corona";

    private final String consumerTag;

    private final String fila;

    public Consumidor(String fila, String consumerTag) {
        this.consumerTag = consumerTag;
        this.fila = fila;
    }

    public static String getExchangeName() {
        return EXCHANGE_NAME;
    }

    public String getConsumerTag() {
        return consumerTag;
    }

    public String getFila() {
        return fila;
    }


    private Date getDate(String date) {
        try {
            DateFormat fmt = new SimpleDateFormat(
                    "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
            return fmt.parse(date);
        } catch (Exception e) {
            return new Date();
        }
    }

    /**
     * Faz parse do Json para os atributos Atendimento
     * @param json JSONObject que contem os dados necessario
     * @return Atendimento
     */
    protected Atendimento parseAtendimento(JSONObject json) {
        final Atendimento atendimento = new Atendimento();

        if (json.has("id")) {
            atendimento.setId(json.getInt("id"));
        }

        if (json.has("dataConfirmacao")) {
            atendimento.setDataConfirmacao(getDate(json.getString(
                    "dataConfirmacao")));
        }

        if (json.has("atendente")) {
            atendimento.setAtendente(this.parseAtendente(
                    json.getJSONObject("atendente")));
        }

        if (json.has("agendamento")) {
            atendimento.setAgendamento(this.parseAgendamento(json
                    .getJSONObject("agendamento")));
        }

        return atendimento;
    }

    /**
     * Faz parse do Json para Agendamento
     * @param json JSONObject que contem os dados necessario
     * @return Agendamento com os dados do json
     */
    protected Agendamento parseAgendamento(JSONObject json) {
        final Agendamento agendamento = new Agendamento();

        if (json.has("id")) {
            agendamento.setId(json.getInt("id"));
        }

        if (json.has("dataAgendamento")) {
            agendamento.setDataAgendamento(getDate(json.getString(
                    "dataAgendamento")));
        }

        if (json.has("paciente")) {
            agendamento.setPaciente(this.parsePaciente(json
                    .getJSONObject("paciente")));
        }

        return agendamento;
    }

    /**
     * Faz parse do Json para Paciente
     * @param json JSONObject que contem os dados necessario
     * @return Paciente com os dados do json
     */
    private Paciente parsePaciente(JSONObject json) {
        final Paciente paciente = new Paciente();

        if (json.has("pcd")) {
            paciente.setPcd(json.getBoolean("pcd"));
        }

        if (json.has("email")) {
            paciente.setEmail(json.getString("email"));
        }


        if (json.has("endereco")) {
            paciente.setEndereco(this.parseEndereco(json
                    .getJSONObject("endereco")));
        }

        return paciente;
    }

    /**
     * Faz parse do Json para Endereco
     * @param json JSONObject que contem os dados necessario
     * @return Endereco com os dados do json
     */
    private Endereco parseEndereco(JSONObject json) {
        final Endereco endereco = new Endereco();

        if (json.has("id")) {
            endereco.setId(json.getInt("id"));
        }

        if (json.has("rua")) {
            endereco.setRua(json.getString("rua"));
        }

        if (json.has("numero")) {
            endereco.setNumero(json.getString("numero"));
        }

        if (json.has("complemento")) {
            endereco.setComplemento(json.getString("complemento"));
        }

        if (json.has("cep")) {
            endereco.setCep(json.getString("cep"));
        }

        if (json.has("bairro")) {
            endereco.setBairro(json.getString("bairro"));
        }

        if (json.has("cidade")) {
            endereco.setCidade(json.getString("cidade"));
        }

        if (json.has("estado")) {
            endereco.setEstado(json.getString("estado"));
        }

        return endereco;
    }

    /**
     * Faz parse do Json para os atributos atendente
     * @param json JSONObject que contem os dados necessario
     * @return Atendente
     */
    private Atendente parseAtendente(JSONObject json) {
        final Atendente atendente = new Atendente();

        if (json.has("codigoCracha")) {
            atendente.setCodigoCracha(json.getString("codigoCracha"));
        }

        this.parsePessoa(atendente, json);
        return atendente;
    }

    /**
     * Faz parse do Json para os atributos pessoa (atualiza objeto por refencia)
     * @param objeto Atendente ou Paciente (atualizado por referencia)
     * @param json JSONObject que contem os dados necessario
     * @param <T> Atendente/Paciente
     */
    private <T extends Pessoa> void parsePessoa(T objeto, JSONObject json) {
        if (json.has("id")) {
            objeto.setId(json.getInt("id"));
        }

        if (json.has("nome")) {
            objeto.setNome(json.getString("nome"));
        }

        if (json.has("sobrenome")) {
            objeto.setSobrenome(json.getString("sobrenome"));
        }

        if (json.has("dataNascimento")) {
            objeto.setDataNascimento(getDate(json.getString(
                    "dataNascimento")));
        }

        if (json.has("cpf")) {
            objeto.setCpf(json.getString("cpf"));
        }

        if (json.has("rg")) {
            objeto.setRg(json.getString("rg"));
        }

        if (json.has("sexo")) {
            objeto.setSexo(PessoaSexo.valueOf(json.getString("sexo")));
        }
    }
}
