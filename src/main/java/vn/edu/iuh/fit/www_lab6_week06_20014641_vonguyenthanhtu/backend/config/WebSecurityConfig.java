package vn.edu.iuh.fit.www_lab6_week06_20014641_vonguyenthanhtu.backend.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = false, securedEnabled = true)
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(antMatcher("/css/**")).permitAll();
                    auth.requestMatchers(antMatcher("/js/**")).permitAll();
                    auth.requestMatchers(antMatcher("/images/**")).permitAll();
                    auth.requestMatchers(antMatcher("/fonts/**")).permitAll();
                    auth.requestMatchers(antMatcher("/webjars/**")).permitAll();
                    auth.requestMatchers(antMatcher("/")).permitAll();
                    auth.requestMatchers(antMatcher("/rss/**")).permitAll();
                    auth.requestMatchers(antMatcher("/register/**")).permitAll();
                    auth.requestMatchers(antMatcher("/posts/**")).permitAll();
                    auth.requestMatchers(PathRequest.toH2Console()).permitAll();
                    auth.anyRequest().authenticated();
                })

                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/")
                        .failureUrl("/login?error")
                        .permitAll()
                );

        return http.build();
    }
}
