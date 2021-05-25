package br.com.next.templates.templateproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_WHITELIST = {
            // -- Actuator
            "/actuator",
            "/actuator/",
            "/actuator/info/**",
            "/actuator/health/**",
            // -- Swagger
            "/swagger-resources/**",
    };

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        http.sessionManagement()
                .sessionFixation()
                .newSession();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}