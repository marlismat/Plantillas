package com.digitel.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.digitel.ConfigAdapter;
import com.digitel.common.ConcatString;
import com.digitel.common.Response;
import com.digitel.exceptions.GenericException;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JwtUtil implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(JwtUtil.class);

	public static HashMap<String,Object> addAuthentication(String username, HttpServletResponse response) {
		
		String firmTokenProp = ConfigAdapter.mapConfAuthenticator.get("tokenSignature");
		String expiryTimeProp = ConfigAdapter.mapConfAuthenticator.get("expiryTime");
				
		String token = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + Integer.parseInt(expiryTimeProp)))
				.signWith(SignatureAlgorithm.HS512, firmTokenProp)
				.compact();
		response.addHeader("Authorization", "Bearer " + token);
		
		HashMap<String,Object> mapToken = new HashMap<String,Object>();
		mapToken.put("authorization","Bearer " + token);
		
		logger.info("Token Generado");
		return mapToken;
		
	}

	public static String getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		try {
			if (token != null) {
				String user = Jwts.parser()
						.setSigningKey(ConfigAdapter.mapConfAuthenticator.get("tokenSignature"))
						.parseClaimsJws(token.replace("Bearer", "")) 
						.getBody().getSubject();
				return user;
			}
		} catch (ExpiredJwtException | MalformedJwtException | SignatureException | UnsupportedJwtException
				| IllegalArgumentException e) {
			
			logger.error(ConcatString.generateSms("Error en: ",Response.getNameMethod() ,null,e.getMessage())); 
			throw new GenericException("007",e);
			
		} catch (Exception e) {

			logger.error(ConcatString.generateSms("Error en: ",Response.getNameMethod() ,null,e.getMessage()));
			System.err.println("error: " + e.getMessage());
			throw new GenericException("007",e);
		}

		return null;
	}
}
