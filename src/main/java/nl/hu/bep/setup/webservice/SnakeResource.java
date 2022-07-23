package nl.hu.bep.setup.webservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import nl.hu.bep.setup.model.GameInfo;
import nl.hu.bep.setup.model.Replays;
import nl.hu.bep.setup.webservice.Request.GameRequest;
import nl.hu.bep.setup.webservice.Request.SnakeUpdateRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

class MoveResponse {
    public String move;
    public String shout;

    public MoveResponse(String move, String shout) {
        this.move = move;
        this.shout = shout;
    }
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

    @PUT
    @Path("/updatesnake")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSnake(SnakeUpdateRequest updatedSnake){
        GameInfo info = new GameInfo();
        info.setHead(updatedSnake.getHead());
        info.setColor(updatedSnake.getColor());
        info.setTail(updatedSnake.getTail());
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
        List<GameRequest> listRequest = Replays.getReplays();
        MoveResponse moveResponse = new MoveResponse("up","Going up");
        listRequest.add(request);
        return Response.ok(moveResponse).build();
    }

    @POST
    @Path("/end")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response stopGame(){
        return Response.ok().build();
    }
}
