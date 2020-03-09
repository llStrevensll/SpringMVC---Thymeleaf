package co.com.strevens.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    //Personalizar usuario desde memoria
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                    .password("{noop}123")//no encriptar password {noop}
                    .roles("ADMIN","USER")
                .and()
                .withUser("user")
                    .password("{noop}123")
                    .roles("USER")
                ;
    }
}
