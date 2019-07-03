package io.namjune.readinglist.config;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/").authenticated()
            .antMatchers("/h2-console/**").permitAll()
            .anyRequest().permitAll()
            .and()
            .csrf()
            .ignoringAntMatchers("/h2-console/**")
            .and()
            .headers()
            .frameOptions().sameOrigin()//h2 console 사용 관련 허용
            .and()
            .formLogin()
            .and()
            .httpBasic();
    }
}
