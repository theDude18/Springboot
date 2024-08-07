package com.boot.springsecurity.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.boot.springsecurity.services.JwtService;
import com.boot.springsecurity.services.MyUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{  //We are extending OncePerRequestFilter bcoz it will make sure that whatever request is called, it will first comes to this JwtFilter 

	@Autowired
	JwtService jwtService;
	
	@Autowired
	ApplicationContext context;
	
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authHeader=request.getHeader("Authorization"); //authHeader contains the token details
		String userName=null;
		String token=null;
		
		//Getting the token & userName
		if(authHeader!=null && authHeader.startsWith("Bearer ")) { //Usually authHeader contains the token detail/number; authHeader starts with Bearer, so checking if it is true.
			//authHeader=Bearer_tokenNumber 
			token= authHeader.substring(7); //getting token num; token num starts at 7th place(like array index)(B-0;t-7).
			userName=jwtService.extractUserName(token); //getting username from token. Token will come in the encoded format. So we need to extract it using extractUserName()
		}
		
		//Validating token & creating authentication obj
		if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) { //2nd condition checks if there is an authentication obj already exists. Only if not, then we will validate the token. I think for the first time alone it will be null, then from 2nd time, it contains Authentication obj and it allows without validating till you logout.
			//.getAuthentication() - this will return us the authentication obj. Security can be implemented in many ways.Spring Security doesn't care abt how we are authenticating. It just needs a authentication obj to know that this entry is authenticated. And we are implementing the authentication/security in JWT way.  
			
			UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(userName);
			
			if(jwtService.validateToken(token,userDetails)) { //passing token and userDetails(it will validate the userName). It validates the token.
				UsernamePasswordAuthenticationToken authToken=       //SpringSecurity uses UsernamePasswordAuthenticationFilter as default filter. So we have to create authentication object for this filter.
						new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities()); // here we are just creating the authentication obj and giving the user details that fetched from DB.
				
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));  //Here we are setting the request details(login details that we entered)
				SecurityContextHolder.getContext().setAuthentication(authToken); //assigning authToken to Spring SecurityContext
				//(SecurityContextHolder.getContext().getAuthentication()==null) - See this 2nd condition of above if stmt checks if the SecurityContext has the authentication obj. Since it is null only, we are getting inside the loop. So, now we have to assign it to the SecurityContext.
				//Now we have created the authentication token
			}
			
		}
		//since we have set this JWTFilter before UserNamePasswordAuthentication filter, we have to to pass this filter to that.
		filterChain.doFilter(request,response);
	}

}
