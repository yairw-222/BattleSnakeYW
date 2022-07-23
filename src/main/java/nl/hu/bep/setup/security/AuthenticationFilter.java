package nl.hu.bep.setup.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import nl.hu.bep.setup.model.UserValidation;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

class AuthenticationRecourse{
    public static String key = "Authorization";
}
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext){
        boolean isSecure= containerRequestContext.getSecurityContext().isSecure();
        String scheme = containerRequestContext.getUriInfo().getRequestUri().getScheme();
        MySecurityContext msc= new MySecurityContext(null,scheme);
        String autHeader= containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if(autHeader != null && autHeader.startsWith("Bearer")){

            String token = autHeader.substring("Bearer".length()).trim();

            try{
                JwtParser parser = Jwts.parser().setSigningKey(AuthenticationRecourse.key);
               Claims claims = parser.parseClaimsJws(token).getBody();

                String user = claims.getSubject();
                msc = new MySecurityContext(UserValidation.findUserByUsername(user),scheme);

            }catch (JwtException| IllegalArgumentException e){
                System.out.println("Invallid JWT, processing guest");
            }

        }
        containerRequestContext.setSecurityContext(msc);
    }
}
