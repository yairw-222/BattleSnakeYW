package nl.hu.bep.setup.webservice;

import io.jsonwebtoken.JwtException;
import nl.hu.bep.setup.model.User;
import nl.hu.bep.setup.model.UserValidation;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.List;

@Path("/users")
@RolesAllowed({"User"})
public class UserRecource {
    JWT_TokenGenerator jwt_tokenGenerator;
    public UserRecource(){
        this.jwt_tokenGenerator= new JWT_TokenGenerator();
    }
    public class LogonRequest{
        public String username,password;
    }

    @RolesAllowed("User")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticationUser(LogonRequest logonRequest){

        try{
          User user =UserValidation.validateLogin(logonRequest.username,logonRequest.password);
          if( user == null) throw new IllegalArgumentException("no user found");

          String token = jwt_tokenGenerator.createToken(user.getUsername(), user.getPassword());

          return Response.ok(new AbstractMap.SimpleEntry<>("JWT", token)).build();
        }catch(JwtException | IllegalArgumentException e){
           return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
