package it.dsibilio.rsocketdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Configuration
public class HomeConfiguration {

    @Bean
    public RouterFunction<ServerResponse> indexRouter(@Value("classpath:/public/index.html") final Resource indexHtml) {
        return route(GET("/"), request -> ok().contentType(MediaType.TEXT_HTML).bodyValue(indexHtml));
    }

}