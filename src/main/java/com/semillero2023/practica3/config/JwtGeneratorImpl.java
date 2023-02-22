package com.semillero2023.practica3.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.semillero2023.practica3.entity.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtGeneratorImpl implements JwtGeneratorInterface {
	private static final Log LOG = LogFactory.getLog(JwtGeneratorImpl.class);

	@Value("${jwt.secret}")
	private String secret;

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	@Override
	public Map<String, String> generateToken(Usuario user) {
		String jwtToken = "";
		jwtToken = Jwts.builder().setSubject(user.getUsername()).setIssuedAt(new Date())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + (5000*60)))
				.compact();
		Map<String, String> jwtTokenGen = new HashMap<>();
		
		LOG.info("Hola mundo");
		jwtTokenGen.put("token", jwtToken);
		return jwtTokenGen;
	}
	

}
