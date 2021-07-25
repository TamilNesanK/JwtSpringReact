package com.jwtreact.jwtreactintegration.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.jwtreact.jwtreactintegration.common.AccessDeniedException;
import com.jwtreact.jwtreactintegration.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	private static String secret = "This_is_secret";
	private long expiryDuration = 60 * 60;

	public String generateToken(User user) {
		long milliTime = System.currentTimeMillis();
		long expiryTime = milliTime + expiryDuration * 1000;
		Date issuedAt = new Date(milliTime);
		Date expiryAt = new Date(expiryTime);
		// claims
		Claims claims = Jwts.claims().setIssuer(user.getId().toString()).setIssuedAt(issuedAt)
				.setExpiration(expiryAt);

		// optinal claims
		claims.put("name", user.getName());
		claims.put("name", user.getEmailId());

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();

	}

	public void verify(String authorization) throws Exception {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization);

		} catch (Exception e) {
			throw new AccessDeniedException("Access Denied");
		}
	}
}

