package com.boot.springsecurity.services;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	String secretKey;
	
	public JwtService(){
		secretKey=generateSecretKey();
	}
	
	//private static final String SECRET = "TmV3U2VjcmV0S2V5Rm9ySldUU2lnbmluZ1B1cnBvc2VzMTIzNDU2Nzg=\r\n"; //we can hardcode the secret key like this, taking it somewhere from the internet.
	
	public String generateSecretKey() { //this method generates a random secret key
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256"); //Uses KeyGenerator to generate a key for HmacSHA256 algorithm
            SecretKey secretKey = keyGen.generateKey();  //generates the key
            System.out.println("Secret Key : " + secretKey.toString());
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());  //encodes the generated key
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating secret key", e);
        }
    }
	
	public String getToken(String username) {	
		
		Map<String,Object> claims=new HashMap<>();
		
		return Jwts.builder()
				.setClaims(claims)  //Map
				.setSubject(username) //subject is username
				.setIssuedAt(new Date(System.currentTimeMillis()))  //setting issuance time as current time
				.setExpiration(new Date(System.currentTimeMillis() + 1000*60*3))  //setting expiration time for 3 min
				.signWith(getKey(), SignatureAlgorithm.HS256).compact(); //setting algorithm, compact() is mandatory for this to work.
	}
	
	public Key getKey() { 
		byte[] keyBytes= Decoders.BASE64.decode(secretKey); //Here we are decoding a Secret encoded message and assigning to it byte datatype
		return Keys.hmacShaKeyFor(keyBytes); //Keys is a class which has hmacShaKeyFor() to return secret key(encrypted message). we need to pass a byte String in the method argument
	}

	 public String extractUserName(String token) {
	        // extract the username from jwt token
	        return extractClaim(token, Claims::getSubject);
	    }

	    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) { //Claims refers to the values like username,expiration & issuance time etc...
	        final Claims claims = extractAllClaims(token);
	        return claimResolver.apply(claims);
	    }

	    private Claims extractAllClaims(String token) {
	        return Jwts.parserBuilder()
	                .setSigningKey(getKey())
	                .build().parseClaimsJws(token).getBody();
	    }


	    public boolean validateToken(String token, UserDetails userDetails) {
	        final String userName = extractUserName(token);
	        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token)); //it will check if the given username is same as username in DB. Note: username will be unique in DB;but we have not set it unique by mistake
	    }

	    private boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }

	    private Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }
	
}


