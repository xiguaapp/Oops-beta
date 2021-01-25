package com.example.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class GatewayFilter extends AbstractGatewayFilterFactory<GatewayFilter.Config> {

    public GatewayFilter() {
        super(Config.class);
    }

    @Override
    public org.springframework.cloud.gateway.filter.GatewayFilter apply(Config config) {
        return this::filter;
    }

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(Myfilter.ATTRIBUTE_IGNORE_TEST_GLOBAL_FILTER, true);
        return chain.filter(exchange);
    }
    public static class Config {
    }
    @Override
    public String name() {
        return "GatewayFilter";
    }
}
