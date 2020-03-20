package Amazin.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class UserConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder a) throws Exception{
        a.jdbcAuthentication().dataSource(dataSource);
    }
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.
                ignoring().antMatchers("/resources/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests().antMatchers("/").permitAll().antMatchers("/bookList").permitAll()
                .antMatchers("/book").hasAnyRole("USER", "ADMIN").antMatchers("/getBook").hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
        http.csrf().disable();
    }
/**
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder a) throws Exception {
        a.inMemoryAuthentication().withUser("Tareq").password("{noop}123").authorities("ROLE_USER", "ROLE_ADMIN");
    }*/
}
