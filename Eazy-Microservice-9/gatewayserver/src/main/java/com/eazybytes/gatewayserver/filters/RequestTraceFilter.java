package com.eazybytes.gatewayserver.filters;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import org.slf4j.Logger;

import org.springframework.http.HttpHeaders;
import java.util.UUID;

@Order(1)
@Component
public class RequestTraceFilter implements GlobalFilter {
    private static final Logger logger = LoggerFactory.getLogger(RequestTraceFilter.class);

    @Autowired
    FilterUtility filterUtility;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
        if(isCorrelationIdPresent(requestHeaders)){
            logger.debug("eazyBank-correlation-id found in RequestTraceFilter : {}", filterUtility.getCorrelationId(requestHeaders));
        }else {
            String correlationID = generateCorrelationId();
            exchange = filterUtility.setRequestHeader(exchange, correlationID);
            logger.debug("eazyBank-correlation-id generated in RequestTraceFilter : {} ", correlationID);
        }
        return chain.filter(exchange);
    }

    private boolean isCorrelationIdPresent(HttpHeaders requestHeaders){
        return requestHeaders.get(FilterUtility.CORRELATION_ID) != null;
    }

    private String generateCorrelationId(){
        return UUID.randomUUID().toString();
    }
}
