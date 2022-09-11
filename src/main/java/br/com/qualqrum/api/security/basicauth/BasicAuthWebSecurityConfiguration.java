// https://www.devglan.com/spring-security/spring-boot-security-rest-basic-authentication
// https://github.com/lokeshgupta1981/Spring-security/blob/master/Spring-security-with-spring-boot/src

package br.com.qualqrum.api.security.basicauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BasicAuthWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppBasicAuthenticationEntryPoint appBasicAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic()
                .authenticationEntryPoint(appBasicAuthenticationEntryPoint);
    }

    // @Autowired
    // public void configureGlobal(AuthenticationManagerBuilder auth) throws
    // Exception {
    // auth.inMemoryAuthentication().withUser("wesley").password("123").roles("USER");
    // }

}