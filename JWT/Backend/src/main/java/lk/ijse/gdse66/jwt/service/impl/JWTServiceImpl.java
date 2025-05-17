package lk.ijse.gdse66.jwt.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lk.ijse.gdse66.jwt.service.JWTService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
public class JWTServiceImpl implements JWTService {

    @Value("12bc367aef7830c87663be7788892adc9983883883e9983777cea8345ad88567370a465121a7717757293d495476a7726a1f9687c3eae8ea5a")
    private String secret_key;

    @Override
    public String generateToken(UserDetails userDetails) {

        HashMap<String, Object> claims = new HashMap<>();
        claims.put("role", userDetails.getUsername());

        Date currentDate = new Date();
        Date expiredDate = new Date(currentDate.getTime() + 1000 * 60 * 60 * 24);

        String accessToken = Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(currentDate)
                .setExpiration(expiredDate)
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
        return accessToken;
    }

    @Override
    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        String subject = extractClaims(token, Claims::getSubject);
        return subject.equals(userDetails.getUsername()) && !isExpired(token);
    }

    private Key getSigninKey() {
        byte[] bytes = Decoders.BASE64.decode(secret_key);
        return Keys.hmacShaKeyFor(bytes);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        Claims allClaims = getAllClaims(token);
        return claimsResolver.apply(allClaims);
    }

    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigninKey()).build().parseClaimsJws(token).getBody();
    }

    private boolean isExpired(String token) {
        Date expiredDate = extractClaims(token, Claims::getExpiration);
        return expiredDate.before(new Date());
    }
}