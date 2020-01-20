/*****************************
 * Copyright (c) 2018. By Adam
 ****************************/

package pl.rmitula.authapp.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest var1, ServletResponse var2, FilterChain chain) throws IOException, ServletException {
        final HttpServletResponse response = (HttpServletResponse) var2;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");
        if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) var1).getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(var1, var2);
        }
    }

    @Override
    public void destroy() {
        // no implementation needed
    }

    @Override
    public void init(FilterConfig config) {
        // no implementation needed
    }

    protected void applyCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*").allowedOrigins("*");
    }
}
