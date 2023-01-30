package com.digitalyouthservices.efactures.security.jwt;

import com.digitalyouthservices.efactures.entity.UserAccount;
import io.jsonwebtoken.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;


@Component
public class JwtUtils {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(JwtUtils.class);

    @Value("${efacture.app.jwtSecret}")
    private String jwtSecret;
    @Value("${efacture.app.jwtExpirationMs}")
    private int jwtExpirationSecond;

    public String generateJwtToken(Authentication authentication){
        UserAccount userPrincipal = (UserAccount) authentication.getPrincipal();
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.SECOND, jwtExpirationSecond);

        return Jwts.builder()
                .setSubject((userPrincipal.getEmail()))
                .setIssuedAt(currentDate)
                .setExpiration(calendar.getTime())
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {

        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateJwtToken(String authToken) {

        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;

    }
}
