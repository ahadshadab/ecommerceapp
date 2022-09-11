package com.javainusestore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class EmployeeSecurityConfiguration{

	/*
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * web.ignoring().antMatchers("/resources/**"); }
	 */
	
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/resources/**");
    }

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/welcome")
	 * .hasAnyRole("USER", "ADMIN").antMatchers("/getEmployees").hasAnyRole("USER",
	 * "ADMIN") .antMatchers("/addNewEmployee").hasAnyRole("ADMIN").anyRequest().
	 * authenticated().and().formLogin() .permitAll().and().logout().permitAll();
	 * 
	  http.csrf().disable(); }
	 */
    
    @Bean
    public DefaultSecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/welcome").hasAnyRole("USER","Admin").antMatchers("/getEmployees")
                .hasAnyRole("USER","ADMIN").antMatchers("/addNewEmployee").hasAnyRole("ADMIN")
                .anyRequest().authenticated().and().formLogin().permitAll().and().logout().permitAll();
        		http.csrf().disable();
        		
        		return http.build();
                
                
                
               /* .hasAnyAuthority("Admin", "Editor", "Salesperson")
                .hasAnyAuthority("Admin", "Editor", "Salesperson", "Shipper")
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login")
                    .usernameParameter("email")
                    .permitAll()
                .and()
                .rememberMe().key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
                .and()
                .logout().permitAll();
 
        http.headers().frameOptions().sameOrigin();
 
        return http.build();*/
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication().withUser("employee").password("employee")
            .authorities("ROLE_USER").and().withUser("javainuse").password("javainuse")
            .authorities("ROLE_USER", "ROLE_ADMIN");
    }

}
