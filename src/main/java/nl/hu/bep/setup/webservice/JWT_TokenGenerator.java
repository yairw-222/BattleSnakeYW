package nl.hu.bep.setup.webservice;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;
import java.util.Calendar;

public class JWT_TokenGenerator {
    final static public Key key = MacProvider.generateKey();

    public String createToken(String username, String role){
        Calendar expiration = Calendar.getInstance();
        expiration.add(Calendar.MINUTE,50);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiration.getTime())
                .claim("role",role)
                .signWith(SignatureAlgorithm.HS512,key)
                .compact();
    }
}
