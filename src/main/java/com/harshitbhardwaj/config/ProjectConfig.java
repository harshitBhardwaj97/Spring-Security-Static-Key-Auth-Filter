package com.harshitbhardwaj.config;

import com.harshitbhardwaj.filters.AuthenticationLoggingFilter;
import com.harshitbhardwaj.filters.StaticKeyAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class ProjectConfig {

    private final StaticKeyAuthenticationFilter staticKeyAuthenticationFilter;
    private final AuthenticationLoggingFilter authenticationLoggingFilter;

    /*
    Injects the filter instances from the Spring context
    */
    public ProjectConfig(StaticKeyAuthenticationFilter staticKeyAuthenticationFilter,
                         AuthenticationLoggingFilter authenticationLoggingFilter) {
        this.staticKeyAuthenticationFilter = staticKeyAuthenticationFilter;
        this.authenticationLoggingFilter = authenticationLoggingFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /*
        Adds the filter at the position of the basic authentication filter in the filter chain
        */
        http.addFilterAt(staticKeyAuthenticationFilter, BasicAuthenticationFilter.class)
                .addFilterBefore(authenticationLoggingFilter, StaticKeyAuthenticationFilter.class)
                .authorizeHttpRequests(authz -> authz.anyRequest().permitAll());

        return http.build();
    }
}
