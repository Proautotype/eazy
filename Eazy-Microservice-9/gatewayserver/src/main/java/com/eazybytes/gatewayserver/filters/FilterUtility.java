package com.eazybytes.gatewayserver.filters;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class FilterUtility {

    public static final Logger logger = LoggerFactory.getLogger(FilterUtility.class);

    public static final String CORRELATION_ID = "eazybank-correlation-id";

    public String getCorrelationId(HttpHeaders requestHttpHeaders){
        if(requestHttpHeaders.get(CORRELATION_ID) != null) {
            List<String> requestHeaderList = requestHttpHeaders.get(CORRELATION_ID);
            assert requestHeaderList != null;
            return requestHeaderList.stream().findFirst().get();
        }
        return null;
    }

    public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String value){
        return exchange.mutate().request(
                exchange.getRequest().mutate().header(name, value).build()
        ).build();
    }

    public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String correlationId){
        return this.setRequestHeader(exchange, CORRELATION_ID, correlationId);
    }

}
