package com.projetosd.coronawebservice.configuracao;

import com.projetosd.coronawebservice.agendamento.AgendamentoService;
import org.jboss.resteasy.plugins.interceptors.CorsFilter;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class ApplicationConfig extends Application {
    private Set<Class<?>> classes = new HashSet<>();

    public ApplicationConfig() {
        classes.add(AgendamentoService.class);
    }

    /**
     * Metodo chamado pelo Jetty Servlet para receber as classes que contém
     * endpoint
     * @return Retorna a lista de classes
     */
    public Set<Class<?>> getClasses() {
        return classes;
    }

    /**
     * Configura o CORS para o Application do JAX-RS
     * @return Set das configuraçòes dos filtros do JAX-RS
     */
    @Override
    public Set<Object> getSingletons() {
        Set<Object> providers = new HashSet<>();
        CorsFilter corsFilter = new CorsFilter();
        corsFilter.getAllowedOrigins().add("*");
        corsFilter.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH");
        providers.add(corsFilter);
        return providers;
    }
}
