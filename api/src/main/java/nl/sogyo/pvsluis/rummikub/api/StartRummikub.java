package nl.sogyo.pvsluis.rummikub.api;

import java.util.ArrayList;
import java.util.Arrays;

import jakarta.servlet.http.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import nl.sogyo.pvsluis.rummikub.api.models.RummikubDTO;
import nl.sogyo.pvsluis.rummikub.api.models.SpelerInputDTO;
import nl.sogyo.pvsluis.rummikub.domain.Rummikub;

@Path("/start")
public class StartRummikub {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response start(
            @Context HttpServletRequest request,
            @Context SpelerInputDTO spelers) {

        HttpSession session = request.getSession(true);

        ArrayList<String> list = new ArrayList<String>(
                Arrays.asList(spelers.getSpelerNamen()));

        Rummikub rummikub = new Rummikub(list);

        session.setAttribute("rummikub", rummikub);

        RummikubDTO output = new RummikubDTO(rummikub);

        return Response.status(200).entity(output).build();

    }

}
