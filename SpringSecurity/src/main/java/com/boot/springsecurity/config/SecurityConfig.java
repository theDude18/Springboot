package com.boot.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.boot.springsecurity.filter.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	JwtFilter jwtFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf(customizer -> customizer.disable())  //Disable CSRF Token; u can perform any crud operation without giving CSRF Token in Headers in Postman
			 .authorizeHttpRequests(request -> request
					 .requestMatchers("register","login") //requestMatchers() will allow this url "register" & "login" alone to be accessed without login credentials. And for this to work, u need to add permitAll().
					 .permitAll()						  //Allows all users to access the specified endpoints (“register” and “login”) without needing to be authenticated.
					 .anyRequest().authenticated())  //Requires authentication for any other requests not specified in the requestMatchers; only if u give Basic Auth in Authorization in Postman, u can access any other requests.
			 .httpBasic(Customizer.withDefaults())  //Enables HTTP Basic authentication, which prompts the user for a username and password via a browser pop-up; And it will ask to login in pop-up instead of form. Only login works & not logout 
			 //.formLogin(Customizer.withDefaults())       //creates form login in beginning after running the app, like in default; when u r making the session stateless, then u dont have to give formlogin
			 .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))  //make the session stateless, (i.e)session id gets changed for every requests;This means that the server does not store any session information, and each request is independent; Provides more security; csrf tokens are not necessary as session id is stateless; FormLogin is not needed when we use session stateless
			 .addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);  //this will execute JwtFilter before UsernamePasswordAuthenticationFilter in the filter chain
			 return http.build();					//Finalizes the configuration and builds the HttpSecurity object
	}    
	
	@Autowired
	UserDetailsService userDetailsService;  //UserDetailsService is only a interface. We need to implement it.So that here it will autowire that implemented class(MyUserDeatilsService). Since it has only one implemented class, it will autowire it without any confusion.
	
	@Bean
	public AuthenticationProvider authProvider() {        //To secure our app with not hard coded username and password
		
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider(); //TO take secure using DB. Checks uname&pswrd from DB
		
		provider.setUserDetailsService(userDetailsService);  //We need UserDetailsService to check if credentials exists in DB.
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));  //when u enter a password, it will encode that password and check it with the encrypted password in DB.
		return provider;  //this will just make sure authentication will be done in the app. And all the functionalities for authentication will be done by UserDetailsService. Also the MyUserDetailsService class will return uname,pswrd and authorities here and the provider checks it with the credentials that we gave and grant the access.
	}

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
	
/*	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails user=User
							.withDefaultPasswordEncoder()
							.username("user")
							.password("@123")
							.roles("USER")
							.build();
		UserDetails admin=User
							.withDefaultPasswordEncoder()
							.username("admin")
							.password("@321")
							.roles("ADMIN")
							.build();
				
		return new InMemoryUserDetailsManager(user,admin);
	}       */
	
	
}




