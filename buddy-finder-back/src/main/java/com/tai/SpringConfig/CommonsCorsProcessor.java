package com.tai.SpringConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.DefaultCorsProcessor;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

import static java.util.stream.Collectors.joining;
import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN;
import static org.springframework.util.StringUtils.hasText;

@Service
public class CommonsCorsProcessor extends DefaultCorsProcessor {

    @Value("${commons.cors.vary:Origin}")
    private String vary;

    @PostConstruct
    public void init() {
        vary = Arrays.asList(vary.replaceAll("(?i)origin", "").split("\\s*,\\s*")).stream().filter(StringUtils::hasText).collect(joining(","));
    }

    @Override
    public boolean processRequest(CorsConfiguration config, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (response.getHeaderNames().contains(ACCESS_CONTROL_ALLOW_ORIGIN)) {
            return true;
        }
        return super.processRequest(config, request, response);
    }

    @Override
    protected boolean handleInternal(ServerHttpRequest request, ServerHttpResponse response, CorsConfiguration config, boolean preFlightRequest) throws IOException {
        if(hasText(vary)) {
            response.getHeaders().set(HttpHeaders.VARY, vary);
        }
        return super.handleInternal(request, response, config, preFlightRequest);
    }

}