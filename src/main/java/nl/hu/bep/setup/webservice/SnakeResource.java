package nl.hu.bep.setup.webservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nl.hu.bep.setup.model.GameInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

class MoveResponse {
    public String move;
    public String shout;

    public MoveResponse(String move, String shout) {
        this.move = move;
        this.shout = shout;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class GameRequest {
    public int turn;
    public  Map<String, Object> you;
}
@Path("/snake")
public class SnakeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGameInfo(){
        GameInfo info = new GameInfo();
        info.setAuthor("YairWestmaas");
        return Response.ok(info).build();
    }

    @POST
    @Path("/start")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response startGame(){
        return Response.ok().build();
    }

    @POST
    @Path("/move")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response move(GameRequest request){
        System.out.println("Snake: "+ request.you.get("name"));

        MoveResponse moveResponse = new MoveResponse("up","Going up");
        return Response.ok(moveResponse).build();
    }

    @POST
    @Path("/end")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response stopGame(){
        return Response.ok().build();
    }
}
