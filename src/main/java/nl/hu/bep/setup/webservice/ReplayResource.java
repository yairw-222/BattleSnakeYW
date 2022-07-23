package nl.hu.bep.setup.webservice;

import nl.hu.bep.setup.model.Replays;
import nl.hu.bep.setup.webservice.Request.GameRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class ReplayResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<GameRequest> getCustomers(){
        return Replays.getReplays();
    }
}
