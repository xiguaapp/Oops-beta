package com.example.filter;

//import com.auth0.jwt.exceptions.AlgorithmMismatchException;
//import com.auth0.jwt.exceptions.SignatureVerificationException;
//import com.auth0.jwt.exceptions.TokenExpiredException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.example.util.JwtUtils;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.commonutils.JwtUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class Myfilter implements GlobalFilter, Ordered{

    public final static String ATTRIBUTE_IGNORE_TEST_GLOBAL_FILTER = "@GatewayFilter";

    //执行顺序
    @Override
    public int getOrder() {
        return 10;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (exchange.getAttribute(ATTRIBUTE_IGNORE_TEST_GLOBAL_FILTER) != null) {
            System.out.println("不拦截跳过..");
            return chain.filter(exchange);
        } else {
            System.out.println("网关全局拦截...");
            //获取请求头
            System.out.println(exchange.getRequest().getHeaders());
            String token = exchange.getRequest().getHeaders().getFirst("token");
            System.out.println("请求头" + token);
//            try {
//                //验证令牌
//                //验证通过处理自己的业务逻辑
//                DecodedJWT verify = JwtUtils.verify(token); //验证令牌
//                System.out.println("验证通过");
//                return chain.filter(exchange);
//            } catch (SignatureVerificationException e) {
//                e.printStackTrace();
//                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//                return exchange.getResponse().setComplete();
//            } catch (TokenExpiredException e) {
//                e.printStackTrace();
//                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//                return exchange.getResponse().setComplete();
//            } catch (AlgorithmMismatchException e) {
//                e.printStackTrace();
//                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//                return exchange.getResponse().setComplete();
//            } catch (Exception e) {
//                e.printStackTrace();
//                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//                return exchange.getResponse().setComplete();
//            }
            return chain.filter(exchange);
        }
    }
}
