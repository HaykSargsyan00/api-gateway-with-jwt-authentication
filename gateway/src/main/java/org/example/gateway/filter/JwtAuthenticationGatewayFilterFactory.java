package org.example.gateway.filter;

import org.example.gateway.util.JwtUtil;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class JwtAuthenticationGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {
    private final JwtUtil jwtUtil;

    public JwtAuthenticationGatewayFilterFactory(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            try {
//                log.info("Incomming request: {} {}", exchange.getRequest().getMethod().name(), exchange.getRequest().getPath());
                String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
                if (token == null || token.isEmpty()) throw new Exception();
                String jwtToken = token.substring(7);
                if(!jwtUtil.validateToken(jwtToken)) throw new Exception();

                String userName = jwtUtil.extractUsername(jwtToken);
                exchange.getAttributes().put("userName", userName);
                return chain.filter(exchange);
            } catch (Exception e) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
        };
    }
}
